
package io.gamemachine.client.messages;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;

import io.protostuff.ByteString;
import io.protostuff.GraphIOUtil;
import io.protostuff.Input;
import io.protostuff.Message;
import io.protostuff.Output;
import io.protostuff.ProtobufOutput;

import java.io.ByteArrayOutputStream;
import io.protostuff.JsonIOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.runtime.RuntimeSchema;

import io.gamemachine.util.LocalLinkedBuffer;


import java.nio.charset.Charset;


import io.protostuff.Schema;
import io.protostuff.UninitializedMessageException;


@SuppressWarnings("unused")
public final class StatusEffectTarget implements Externalizable, Message<StatusEffectTarget>, Schema<StatusEffectTarget>{

	public enum Action implements io.protostuff.EnumLite<Action>
    {
    	
    	    	None(0),    	    	Apply(1),    	    	Remove(2);    	        
        public final int number;
        
        private Action (int number)
        {
            this.number = number;
        }
        
        public int getNumber()
        {
            return number;
        }
        
        public static Action valueOf(int number)
        {
            switch(number) 
            {
            	    			case 0: return (None);
    			    			case 1: return (Apply);
    			    			case 2: return (Remove);
    			                default: return null;
            }
        }
    }
	public enum PassiveFlag implements io.protostuff.EnumLite<PassiveFlag>
    {
    	
    	    	NA(0),    	    	AutoRemove(1),    	    	ManualRemove(2);    	        
        public final int number;
        
        private PassiveFlag (int number)
        {
            this.number = number;
        }
        
        public int getNumber()
        {
            return number;
        }
        
        public static PassiveFlag valueOf(int number)
        {
            switch(number) 
            {
            	    			case 0: return (NA);
    			    			case 1: return (AutoRemove);
    			    			case 2: return (ManualRemove);
    			                default: return null;
            }
        }
    }


    public static Schema<StatusEffectTarget> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static StatusEffectTarget getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final StatusEffectTarget DEFAULT_INSTANCE = new StatusEffectTarget();

    			public String target;
	    
        			public String skill;
	    
        			public GmVector3 location;
	    
        			public Integer range;
	    
            public List<StatusEffect> statusEffect;
	    			public String origin;
	    
        			public Integer ticks;
	    
        			public Long activeId;
	    
        			public Long lastTick;
	    
        			public Action action; // = None:0;
	    
        			public PassiveFlag passiveFlag; // = NA:0;
	    
      
    public StatusEffectTarget()
    {
        
    }


	

	    
    public Boolean hasTarget()  {
        return target == null ? false : true;
    }
        
		public String getTarget() {
		return target;
	}
	
	public StatusEffectTarget setTarget(String target) {
		this.target = target;
		return this;	}
	
		    
    public Boolean hasSkill()  {
        return skill == null ? false : true;
    }
        
		public String getSkill() {
		return skill;
	}
	
	public StatusEffectTarget setSkill(String skill) {
		this.skill = skill;
		return this;	}
	
		    
    public Boolean hasLocation()  {
        return location == null ? false : true;
    }
        
		public GmVector3 getLocation() {
		return location;
	}
	
	public StatusEffectTarget setLocation(GmVector3 location) {
		this.location = location;
		return this;	}
	
		    
    public Boolean hasRange()  {
        return range == null ? false : true;
    }
        
		public Integer getRange() {
		return range;
	}
	
	public StatusEffectTarget setRange(Integer range) {
		this.range = range;
		return this;	}
	
		    
    public Boolean hasStatusEffect()  {
        return statusEffect == null ? false : true;
    }
        
		public List<StatusEffect> getStatusEffectList() {
		if(this.statusEffect == null)
            this.statusEffect = new ArrayList<StatusEffect>();
		return statusEffect;
	}

	public StatusEffectTarget setStatusEffectList(List<StatusEffect> statusEffect) {
		this.statusEffect = statusEffect;
		return this;
	}

	public StatusEffect getStatusEffect(int index)  {
        return statusEffect == null ? null : statusEffect.get(index);
    }

    public int getStatusEffectCount()  {
        return statusEffect == null ? 0 : statusEffect.size();
    }

    public StatusEffectTarget addStatusEffect(StatusEffect statusEffect)  {
        if(this.statusEffect == null)
            this.statusEffect = new ArrayList<StatusEffect>();
        this.statusEffect.add(statusEffect);
        return this;
    }
            	    	    	    	    	
    public StatusEffectTarget removeStatusEffectById(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.id.equals(obj.id)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByDuration(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.duration.equals(obj.duration)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByTicks(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.ticks.equals(obj.ticks)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByAttribute(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.attribute.equals(obj.attribute)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByMinValue(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.minValue.equals(obj.minValue)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByMaxValue(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.maxValue.equals(obj.maxValue)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByParticleEffect(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.particleEffect.equals(obj.particleEffect)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	    	
    public StatusEffectTarget removeStatusEffectByIcon_path(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.icon_path.equals(obj.icon_path)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public StatusEffectTarget removeStatusEffectByIcon_uuid(StatusEffect statusEffect)  {
    	if(this.statusEffect == null)
           return this;
            
       	Iterator<StatusEffect> itr = this.statusEffect.iterator();
       	while (itr.hasNext()) {
    	StatusEffect obj = itr.next();
    	
    	    		if (statusEffect.icon_uuid.equals(obj.icon_uuid)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
            	
    
    
    
		    
    public Boolean hasOrigin()  {
        return origin == null ? false : true;
    }
        
		public String getOrigin() {
		return origin;
	}
	
	public StatusEffectTarget setOrigin(String origin) {
		this.origin = origin;
		return this;	}
	
		    
    public Boolean hasTicks()  {
        return ticks == null ? false : true;
    }
        
		public Integer getTicks() {
		return ticks;
	}
	
	public StatusEffectTarget setTicks(Integer ticks) {
		this.ticks = ticks;
		return this;	}
	
		    
    public Boolean hasActiveId()  {
        return activeId == null ? false : true;
    }
        
		public Long getActiveId() {
		return activeId;
	}
	
	public StatusEffectTarget setActiveId(Long activeId) {
		this.activeId = activeId;
		return this;	}
	
		    
    public Boolean hasLastTick()  {
        return lastTick == null ? false : true;
    }
        
		public Long getLastTick() {
		return lastTick;
	}
	
	public StatusEffectTarget setLastTick(Long lastTick) {
		this.lastTick = lastTick;
		return this;	}
	
		    
    public Boolean hasAction()  {
        return action == null ? false : true;
    }
        
		public Action getAction() {
		return action;
	}
	
	public StatusEffectTarget setAction(Action action) {
		this.action = action;
		return this;	}
	
		    
    public Boolean hasPassiveFlag()  {
        return passiveFlag == null ? false : true;
    }
        
		public PassiveFlag getPassiveFlag() {
		return passiveFlag;
	}
	
	public StatusEffectTarget setPassiveFlag(PassiveFlag passiveFlag) {
		this.passiveFlag = passiveFlag;
		return this;	}
	
	
  
    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<StatusEffectTarget> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public StatusEffectTarget newMessage()
    {
        return new StatusEffectTarget();
    }

    public Class<StatusEffectTarget> typeClass()
    {
        return StatusEffectTarget.class;
    }

    public String messageName()
    {
        return StatusEffectTarget.class.getSimpleName();
    }

    public String messageFullName()
    {
        return StatusEffectTarget.class.getName();
    }

    public boolean isInitialized(StatusEffectTarget message)
    {
        return true;
    }

    public void mergeFrom(Input input, StatusEffectTarget message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                            	case 1:
            	                	                	message.target = input.readString();
                	break;
                	                	
                            	            	case 2:
            	                	                	message.skill = input.readString();
                	break;
                	                	
                            	            	case 3:
            	                	                	message.location = input.mergeObject(message.location, GmVector3.getSchema());
                    break;
                                    	
                            	            	case 4:
            	                	                	message.range = input.readInt32();
                	break;
                	                	
                            	            	case 5:
            	            		if(message.statusEffect == null)
                        message.statusEffect = new ArrayList<StatusEffect>();
                                        message.statusEffect.add(input.mergeObject(null, StatusEffect.getSchema()));
                                        break;
                            	            	case 6:
            	                	                	message.origin = input.readString();
                	break;
                	                	
                            	            	case 7:
            	                	                	message.ticks = input.readInt32();
                	break;
                	                	
                            	            	case 8:
            	                	                	message.activeId = input.readInt64();
                	break;
                	                	
                            	            	case 9:
            	                	                	message.lastTick = input.readInt64();
                	break;
                	                	
                            	            	case 10:
            	                	                    message.action = Action.valueOf(input.readEnum());
                    break;
                	                	
                            	            	case 11:
            	                	                    message.passiveFlag = PassiveFlag.valueOf(input.readEnum());
                    break;
                	                	
                            	            
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, StatusEffectTarget message) throws IOException
    {
    	    	
    	    	if(message.target == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.target != null)
            output.writeString(1, message.target, false);
    	    	
    	            	
    	    	if(message.skill == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.skill != null)
            output.writeString(2, message.skill, false);
    	    	
    	            	
    	    	
    	    	    	if(message.location != null)
    		output.writeObject(3, message.location, GmVector3.getSchema(), false);
    	    	
    	            	
    	    	
    	    	    	if(message.range != null)
            output.writeInt32(4, message.range, false);
    	    	
    	            	
    	    	
    	    	if(message.statusEffect != null)
        {
            for(StatusEffect statusEffect : message.statusEffect)
            {
                if(statusEffect != null) {
                   	    				output.writeObject(5, statusEffect, StatusEffect.getSchema(), true);
    				    			}
            }
        }
    	            	
    	    	if(message.origin == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.origin != null)
            output.writeString(6, message.origin, false);
    	    	
    	            	
    	    	
    	    	    	if(message.ticks != null)
            output.writeInt32(7, message.ticks, false);
    	    	
    	            	
    	    	
    	    	    	if(message.activeId != null)
            output.writeInt64(8, message.activeId, false);
    	    	
    	            	
    	    	
    	    	    	if(message.lastTick != null)
            output.writeInt64(9, message.lastTick, false);
    	    	
    	            	
    	    	if(message.action == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.action != null)
    	 	output.writeEnum(10, message.action.number, false);
    	    	
    	            	
    	    	if(message.passiveFlag == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.passiveFlag != null)
    	 	output.writeEnum(11, message.passiveFlag.number, false);
    	    	
    	            	
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	        	case 1: return "target";
        	        	case 2: return "skill";
        	        	case 3: return "location";
        	        	case 4: return "range";
        	        	case 5: return "statusEffect";
        	        	case 6: return "origin";
        	        	case 7: return "ticks";
        	        	case 8: return "activeId";
        	        	case 9: return "lastTick";
        	        	case 10: return "action";
        	        	case 11: return "passiveFlag";
        	            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
    	    	__fieldMap.put("target", 1);
    	    	__fieldMap.put("skill", 2);
    	    	__fieldMap.put("location", 3);
    	    	__fieldMap.put("range", 4);
    	    	__fieldMap.put("statusEffect", 5);
    	    	__fieldMap.put("origin", 6);
    	    	__fieldMap.put("ticks", 7);
    	    	__fieldMap.put("activeId", 8);
    	    	__fieldMap.put("lastTick", 9);
    	    	__fieldMap.put("action", 10);
    	    	__fieldMap.put("passiveFlag", 11);
    	    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = StatusEffectTarget.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static StatusEffectTarget parseFrom(byte[] bytes) {
	StatusEffectTarget message = new StatusEffectTarget();
	ProtobufIOUtil.mergeFrom(bytes, message, StatusEffectTarget.getSchema());
	return message;
}

public static StatusEffectTarget parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	StatusEffectTarget message = new StatusEffectTarget();
	JsonIOUtil.mergeFrom(bytes, message, StatusEffectTarget.getSchema(), false);
	return message;
}

public StatusEffectTarget clone() {
	byte[] bytes = this.toByteArray();
	StatusEffectTarget statusEffectTarget = StatusEffectTarget.parseFrom(bytes);
	return statusEffectTarget;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, StatusEffectTarget.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<StatusEffectTarget> schema = StatusEffectTarget.getSchema();
    
	final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ProtobufOutput output = new ProtobufOutput(buffer);
    try
    {
    	schema.writeTo(output, this);
        final int size = output.getSize();
        ProtobufOutput.writeRawVarInt32Bytes(out, size);
        final int msgSize = LinkedBuffer.writeTo(out, buffer);
        assert size == msgSize;
        
        buffer.clear();
        return out.toByteArray();
    }
    catch (IOException e)
    {
        throw new RuntimeException("Serializing to a byte array threw an IOException " + 
                "(should never happen).", e);
    }
 
}

public byte[] toProtobuf() {
	LinkedBuffer buffer = LocalLinkedBuffer.get();
	byte[] bytes = null;

	try {
		bytes = ProtobufIOUtil.toByteArray(this, StatusEffectTarget.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

}
