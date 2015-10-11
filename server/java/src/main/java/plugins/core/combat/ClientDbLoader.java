
package plugins.core.combat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.gamemachine.config.AppConfig;
import io.gamemachine.messages.CraftingRecipes;
import io.gamemachine.messages.PlayerItems;
import io.gamemachine.messages.PlayerSkills;
import io.gamemachine.messages.StatusEffects;
import io.gamemachine.messages.VitalsContainer;

public class ClientDbLoader {

	
	private static byte[] LoadProtoFile(String name) {
		Path path = Paths.get(dbPath(name));
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private static String dbPath(String name) {
		return AppConfig.getEnvRoot() + "/db/"+name;
	}
	
	public static VitalsContainer getVitalsContainer() {
		String name = "VitalsCatalog.proto";
		if (new File(dbPath(name)).exists()) {
			return VitalsContainer.parseFrom(LoadProtoFile(name));
		} else {
			return new VitalsContainer();
		}
	}
	
	public static StatusEffects getStatusEffects() {
		String name = "StatusEffectCatalog.proto";
		if (new File(dbPath(name)).exists()) {
			return StatusEffects.parseFrom(LoadProtoFile(name));
		} else {
			return new StatusEffects();
		}
	}
	
	public static PlayerSkills getPlayerSkills() {
		String name = "PlayerSkillCatalog.proto";
		if (new File(dbPath(name)).exists()) {
			return PlayerSkills.parseFrom(LoadProtoFile(name));
		} else {
			return new PlayerSkills();
		}
	}
	
	public static PlayerItems getPlayerItems() {
		String name = "ItemCatalog.proto";
		if (new File(dbPath(name)).exists()) {
			return PlayerItems.parseFrom(LoadProtoFile(name));
		} else {
			return new PlayerItems();
		}
	}
	
	public static CraftingRecipes getCraftingRecipes() {
		String name = "CraftingRecipeCatalog.proto";
		if (new File(dbPath(name)).exists()) {
			return CraftingRecipes.parseFrom(LoadProtoFile(name));
		} else {
			return new CraftingRecipes();
		}
	}
	
	
}