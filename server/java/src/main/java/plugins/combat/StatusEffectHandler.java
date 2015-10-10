package plugins.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import io.gamemachine.config.AppConfig;
import io.gamemachine.core.ActorUtil;
import io.gamemachine.core.CharacterService;
import io.gamemachine.core.ChatSubscriptions;
import io.gamemachine.core.GameGrid;
import io.gamemachine.core.Grid;
import io.gamemachine.messages.Attack;
import io.gamemachine.messages.Character;
import io.gamemachine.messages.PlayerSkill;
import io.gamemachine.messages.StatusEffect;
import io.gamemachine.messages.StatusEffectTarget;
import io.gamemachine.messages.TrackData;
import io.gamemachine.messages.Vitals;
import plugins.landrush.BuildObjectHandler;
import scala.concurrent.duration.Duration;

public class StatusEffectHandler extends UntypedActor {

	public static ConcurrentHashMap<String, StatusEffect> statusEffects = new ConcurrentHashMap<String, StatusEffect>();
	public static ConcurrentHashMap<String, List<StatusEffect>> skillEffects = new ConcurrentHashMap<String, List<StatusEffect>>();

	private Map<String, Long> deathTimer = new ConcurrentHashMap<String, Long>();
	private Map<Long, StatusEffectTarget> targets = new ConcurrentHashMap<Long, StatusEffectTarget>();

	private AtomicLong counter = new AtomicLong();
	private static String name = StatusEffectHandler.class.getSimpleName();
	private LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

	private long deathTime = 15000L;
	private int zone = -1;
	private Grid grid = null;

	public static void tell(String gridName, int zone, StatusEffectTarget statusEffectTarget, ActorRef sender) {
		ActorSelection sel = ActorUtil.getSelectionByName(actorName(gridName, zone));
		sel.tell(statusEffectTarget, sender);
	}

	public static String actorName(String gridName, int zone) {
		return StatusEffectHandler.name + gridName + zone;
	}

	public StatusEffectHandler(String gridName, int zone) {
		this.zone = zone;
		grid = GameGrid.getGameGrid(AppConfig.getDefaultGameId(), gridName, zone);
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof StatusEffectTarget) {
			StatusEffectTarget statusEffectTarget = (StatusEffectTarget) message;
			useSkillOnTarget(statusEffectTarget);
		} else if (message instanceof String) {
			if (message.equals("vitals_tick")) {
				updateVitals();
				tick(1000L, "vitals_tick");
			} else if (message.equals("effects_tick")) {
				for (StatusEffectTarget statusEffectTarget : targets.values()) {
					if ((System.currentTimeMillis() - statusEffectTarget.lastTick) >= 1000l) {
						applyAttributeEffects(statusEffectTarget);

						if (hasActiveEffect(statusEffectTarget)) {
							statusEffectTarget.lastTick = System.currentTimeMillis();
						} else {
							targets.remove(statusEffectTarget.activeId);
						}
					}
				}
				tick(300L, "effects_tick");
			}
		}
	}

	private void skillUp(PlayerSkill playerSkill, String characterId) {
		int chance = randInt(1, 10);
		if (chance < 5) {
			return;
		}

		Character character = CharacterService.instance().find(characterId);
		if (character == null) {
			logger.warning("Unable to find character for " + characterId);
			return;
		}

		if (PlayerSkillHandler.hasPlayerSkill(playerSkill.id, character.id)) {
			PlayerSkill existing = PlayerSkillHandler.playerSkill(playerSkill.id, character.id);
			existing.level += 1;
			PlayerSkillHandler.savePlayerSkill(existing);
			logger.warning("Skill up " + playerSkill.id + " level " + existing.level);
		}
	}

	private long useSkillOnTarget(StatusEffectTarget statusEffectTarget) {
		long activeId;

		if (statusEffectTarget.action == StatusEffectTarget.Action.Remove) {

			if (statusEffectTarget.passiveFlag == StatusEffectTarget.PassiveFlag.AutoRemove) {
				StatusEffect effect = statusEffectTarget.statusEffect.get(0);
				// setPassiveEffect(effect.type, vitals, effect.minValue, true);
				logger.warning("Removing " + effect.type + " from " + statusEffectTarget.originEntityId);
			} else {
				for (StatusEffect effect : skillEffects.get(statusEffectTarget.attack.playerSkill.id)) {
					// setPassiveEffect(effect.type, vitals, effect.minValue,
					// true);
				}
			}
			activeId = 0;
		} else {
			activeId = setStatusEffects(statusEffectTarget);
			applyAttributeEffects(statusEffectTarget);
			statusEffectTarget.lastTick = System.currentTimeMillis();
		}

		skillUp(statusEffectTarget.attack.playerSkill, statusEffectTarget.originCharacterId);
		return activeId;
	}

	private void setPassiveEffect(StatusEffectTarget statusEffectTarget, Vitals targetVitals,
			StatusEffect statusEffect) {
		int value = statusEffect.minValue;
		//setPassiveEffect(statusEffect.type, targetVitals, value, false);

		if (statusEffectTarget.action == StatusEffectTarget.Action.Apply
				&& statusEffectTarget.passiveFlag == StatusEffectTarget.PassiveFlag.AutoRemove) {
			statusEffectTarget = statusEffectTarget.clone();
			statusEffectTarget.targetEntityId = targetVitals.entityId;
			statusEffect = statusEffect.clone();
			statusEffectTarget.statusEffect.clear();
			statusEffectTarget.action = StatusEffectTarget.Action.Remove;
			// statusEffectTarget.passiveFlag =
			// StatusEffectTarget.PassiveFlag.NA;
			statusEffectTarget.addStatusEffect(statusEffect);
			logger.warning("scheduling removal of " + statusEffect.type + " from " + targetVitals.entityId + " in "
					+ statusEffect.ticks);
			getContext().system().scheduler().scheduleOnce(Duration.create((long) statusEffect.ticks, TimeUnit.SECONDS),
					getSelf(), statusEffectTarget, getContext().dispatcher(), null);
		}
	}

	private long setStatusEffects(StatusEffectTarget statusEffectTarget) {
		boolean multi = false;
		for (StatusEffect effect : skillEffects.get(statusEffectTarget.attack.playerSkill.id)) {
			statusEffectTarget.addStatusEffect(effect.clone());
			if (effect.ticks > 1) {
				multi = true;
			}
		}

		if (multi) {
			statusEffectTarget.activeId = counter.getAndIncrement();
			targets.put(statusEffectTarget.activeId, statusEffectTarget);
			return statusEffectTarget.activeId;
		} else {
			return 0l;
		}
	}

	private boolean hasActiveEffect(StatusEffectTarget statusEffectTarget) {
		for (StatusEffect effect : statusEffectTarget.statusEffect) {
			if (effect.ticksPerformed < effect.ticks) {
				return true;
			}
		}
		return false;
	}

	private boolean isPassive(StatusEffect statusEffect) {
		if (statusEffect.type != StatusEffect.Type.AttributeIncrease
				&& statusEffect.type != StatusEffect.Type.AttributeDecrease) {
			return true;
		} else {
			return false;
		}
	}

	private void applyAttributeEffects(StatusEffectTarget statusEffectTarget) {
		List<StatusEffect> effectsToRemove = null;
		
		statusEffectTarget.originVitals.lastCombat = System.currentTimeMillis();
		
		for (StatusEffect statusEffect : statusEffectTarget.statusEffect) {
			if (statusEffect.ticksPerformed < statusEffect.ticks) {
				//logger.warning("Tick " + statusEffect.ticksPerformed + " " + statusEffect.id);

				if (!DeductCost(statusEffectTarget.originVitals, statusEffect)) {
					statusEffect.ticksPerformed += 1;
					continue;
				}
				
				if (statusEffectTarget.attack.playerSkill.damageType.equals(PlayerSkill.DamageType.Aoe.toString())
						|| statusEffectTarget.attack.playerSkill.damageType
								.equals(PlayerSkill.DamageType.Pbaoe.toString())) {

					for (TrackData trackData : AoeUtil.getTargetsInRange(statusEffect.range, statusEffectTarget.location,
							grid)) {
						Vitals targetVitals = VitalsHandler.fromTrackData(trackData, zone);
						applyAttributeEffect(statusEffectTarget, statusEffectTarget.originVitals, targetVitals, statusEffect);
					}
				} else {
					applyAttributeEffect(statusEffectTarget, statusEffectTarget.originVitals, statusEffectTarget.targetVitals, statusEffect);
				}
				statusEffect.ticksPerformed += 1;
			}
			if (isPassive(statusEffect)) {
				if (effectsToRemove == null) {
					effectsToRemove = new ArrayList<StatusEffect>();
				}
				effectsToRemove.add(statusEffect);
			}
		}

		if (effectsToRemove != null) {
			for (StatusEffect effect : effectsToRemove) {
				statusEffectTarget.removeStatusEffectById(effect);
			}
		}

	}

	private int applyAttributeEffect(StatusEffectTarget statusEffectTarget, Vitals originVitals, Vitals targetVitals,
			StatusEffect statusEffect) {
		
		if (isPassive(statusEffect)) {
			setPassiveEffect(statusEffectTarget, targetVitals, statusEffect);
			return 0;
		}

		if (targetVitals.dead == 1) {
			return 0;
		}

		targetVitals.lastCombat = System.currentTimeMillis();

		Vitals targetTemplate = VitalsHandler.getBase(targetVitals);

		Vitals.Attribute attribute = Vitals.Attribute.valueOf(statusEffect.attribute);

		int targetBaseValue = VitalsHandler.getAttribute(targetTemplate, attribute);
		int targetCurrentValue = VitalsHandler.getAttribute(targetVitals, attribute);

		int value = getEffectValue(statusEffect, statusEffectTarget.attack.playerSkill,
				statusEffectTarget.originCharacterId);

		if (statusEffect.type == StatusEffect.Type.AttributeDecrease) {

			if (targetVitals.type == Vitals.VitalsType.Character) {
				// no damage to self
				if (targetVitals.characterId.equals(statusEffectTarget.originCharacterId)) {
					return 0;
				}

				// or group members
				if (inSameGroup(statusEffectTarget.originCharacterId, targetVitals.characterId)) {
					return 0;
				}
			}

			VitalsHandler.setAttribute(targetVitals, attribute, targetCurrentValue - value);
			if (targetCurrentValue < 0) {
				VitalsHandler.setAttribute(targetVitals, attribute, 0);
			}
		} else if (statusEffect.type == StatusEffect.Type.AttributeIncrease) {

			if (targetVitals.type == Vitals.VitalsType.Character) {
				// only to self or group members
				if (targetVitals.characterId.equals(statusEffectTarget.originCharacterId)
						|| inSameGroup(statusEffectTarget.originCharacterId, targetVitals.characterId)) {
					targetVitals.health += value;
					VitalsHandler.setAttribute(targetVitals, attribute, targetCurrentValue);
					if (targetCurrentValue > targetBaseValue) {
						VitalsHandler.setAttribute(targetVitals, attribute, targetBaseValue);
					}
				} else {
					return 0;
				}
			}
		}

		if (value > 0) {
			if (targetVitals.type == Vitals.VitalsType.Object && attribute == Vitals.Attribute.Health) {
				BuildObjectHandler.setHealth(targetVitals.entityId, targetVitals.health);
			}
			
			targetVitals.changed = 1;
			 //logger.warning("target " + targetVitals.entityId + " damage " + value + " type " + statusEffect.type + " health " + targetVitals.health);
		}

		return value;
	}

	private boolean DeductCost(Vitals vitals, StatusEffect statusEffect) {
		if (statusEffect.resourceCost == 0) {
			return true;
		}

		if (statusEffect.resource == StatusEffect.Resource.ResourceStamina) {
			if (vitals.stamina < statusEffect.resourceCost) {
				logger.warning("Insufficient stamina needed " + statusEffect.resourceCost);
				return false;
			}
			vitals.stamina -= statusEffect.resourceCost;
		} else if (statusEffect.resource == StatusEffect.Resource.ResourceMagic) {
			if (vitals.magic < statusEffect.resourceCost) {
				logger.warning("Insufficient magic needed " + statusEffect.resourceCost);
				return false;
			}
			vitals.magic -= statusEffect.resourceCost;
		}
		return true;
	}

	private boolean inGroup(String playerId) {
		String playerGroup = ChatSubscriptions.playerGroup(playerId);
		if (playerGroup.equals("nogroup")) {
			return false;
		} else {
			return true;
		}
	}

	private String playerGroup(String playerId) {
		return ChatSubscriptions.playerGroup(playerId);
	}

	private boolean inSameGroup(String playerId, String otherId) {
		if (!inGroup(playerId)) {
			return false;
		}

		String otherGroup = ChatSubscriptions.playerGroup(otherId);

		if (playerGroup(playerId).equals(otherGroup)) {
			return true;
		} else {
			return false;
		}
	}

	private int getEffectValue(StatusEffect statusEffect, PlayerSkill playerSkill, String characterId) {
		int base = randInt(statusEffect.minValue, statusEffect.maxValue);
		Character character = CharacterService.instance().find(characterId);
		int level = skillLevel(playerSkill.id, character.id);
		return base + level;
	}

	// Can be a skill or player item
	private int skillLevel(String id, String characterId) {
		if (PlayerSkillHandler.hasPlayerSkill(id, characterId)) {
			PlayerSkill playerSkill = PlayerSkillHandler.playerSkill(id, characterId);
			return playerSkill.level;
		} else {
			return 0;
		}
	}

	private void die(Vitals vitals) {
		vitals.health = 0;
		vitals.stamina = 0;
		vitals.magic = 0;
		vitals.dead = 1;
		vitals.changed = 1;
	}

	private void revive(Vitals vitals) {
		Vitals template = VitalsHandler.getBase(vitals);
		vitals.dead = 0;
		vitals.health = template.health;
		vitals.stamina = template.stamina;
		vitals.magic = template.magic;
		vitals.changed = 1;
	}

	private void updateVitals() {
		int regen;

		for (Vitals vitals : VitalsHandler.getVitals()) {
			
			Vitals template = VitalsHandler.getBase(vitals);
			int stamina = template.stamina;
			int magic = template.magic;
			int health = template.health;

			if (vitals.dead == 1) {
				if (vitals.type == Vitals.VitalsType.Object) {
					BuildObjectHandler.setHealth(vitals.entityId, vitals.health);
					VitalsHandler.remove(vitals.entityId);
					continue;
				}

				if (deathTimer.containsKey(vitals.entityId)) {
					Long timeDead = deathTimer.get(vitals.entityId);
					Long timer = deathTime;
					if ((System.currentTimeMillis() - timeDead) > timer) {
						revive(vitals);
						deathTimer.remove(vitals.entityId);
					}
				}
				continue;
			}

			if (vitals.health <= 0) {
				die(vitals);
				deathTimer.put(vitals.entityId, System.currentTimeMillis());
				continue;
			}

			if (vitals.health < health) {
				vitals.health += vitals.healthRegen;
				vitals.changed = 1;
				if (vitals.health > health) {
					vitals.health = health;
				}
			}

			if (vitals.stamina < stamina) {
				vitals.stamina +=vitals.staminaRegen;
				vitals.changed = 1;
				if (vitals.stamina > stamina) {
					vitals.stamina = stamina;
				}
			}

			if (vitals.magic < magic) {
				vitals.magic += vitals.magicRegen;
				vitals.changed = 1;
				if (vitals.magic > magic) {
					vitals.magic = magic;
				}
			}

		}
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	@Override
	public void preStart() {
		tick(300L, "effects_tick");
		tick(1000L, "vitals_tick");
	}

	public void tick(long delay, String message) {
		getContext().system().scheduler().scheduleOnce(Duration.create(delay, TimeUnit.MILLISECONDS), getSelf(),
				message, getContext().dispatcher(), null);
	}

}
