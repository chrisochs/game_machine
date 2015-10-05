
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
public final class StatusEffectResult implements Externalizable, Message<StatusEffectResult>, Schema<StatusEffectResult>{



    public static Schema<StatusEffectResult> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static StatusEffectResult getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final StatusEffectResult DEFAULT_INSTANCE = new StatusEffectResult();

    			public String target;
	    
        			public String origin;
	    
        			public int value;
	    
        			public String statusEffectId;
	    
      
    public StatusEffectResult()
    {
        
    }


	

	    
    public Boolean hasTarget()  {
        return target == null ? false : true;
    }
        
		public String getTarget() {
		return target;
	}
	
	public StatusEffectResult setTarget(String target) {
		this.target = target;
		return this;	}
	
		    
    public Boolean hasOrigin()  {
        return origin == null ? false : true;
    }
        
		public String getOrigin() {
		return origin;
	}
	
	public StatusEffectResult setOrigin(String origin) {
		this.origin = origin;
		return this;	}
	
		    
    public Boolean hasValue()  {
        return value == null ? false : true;
    }
        
		public int getValue() {
		return value;
	}
	
	public StatusEffectResult setValue(int value) {
		this.value = value;
		return this;	}
	
		    
    public Boolean hasStatusEffectId()  {
        return statusEffectId == null ? false : true;
    }
        
		public String getStatusEffectId() {
		return statusEffectId;
	}
	
	public StatusEffectResult setStatusEffectId(String statusEffectId) {
		this.statusEffectId = statusEffectId;
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

    public Schema<StatusEffectResult> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public StatusEffectResult newMessage()
    {
        return new StatusEffectResult();
    }

    public Class<StatusEffectResult> typeClass()
    {
        return StatusEffectResult.class;
    }

    public String messageName()
    {
        return StatusEffectResult.class.getSimpleName();
    }

    public String messageFullName()
    {
        return StatusEffectResult.class.getName();
    }

    public boolean isInitialized(StatusEffectResult message)
    {
        return true;
    }

    public void mergeFrom(Input input, StatusEffectResult message) throws IOException
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
            	                	                	message.origin = input.readString();
                	break;
                	                	
                            	            	case 3:
            	                	                	message.value = input.readInt32();
                	break;
                	                	
                            	            	case 4:
            	                	                	message.statusEffectId = input.readString();
                	break;
                	                	
                            	            
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, StatusEffectResult message) throws IOException
    {
    	    	
    	    	if(message.target == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.target != null)
            output.writeString(1, message.target, false);
    	    	
    	            	
    	    	if(message.origin == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.origin != null)
            output.writeString(2, message.origin, false);
    	    	
    	            	
    	    	if(message.value == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.value != null)
            output.writeInt32(3, message.value, false);
    	    	
    	            	
    	    	if(message.statusEffectId == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.statusEffectId != null)
            output.writeString(4, message.statusEffectId, false);
    	    	
    	            	
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	        	case 1: return "target";
        	        	case 2: return "origin";
        	        	case 3: return "value";
        	        	case 4: return "statusEffectId";
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
    	    	__fieldMap.put("origin", 2);
    	    	__fieldMap.put("value", 3);
    	    	__fieldMap.put("statusEffectId", 4);
    	    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = StatusEffectResult.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static StatusEffectResult parseFrom(byte[] bytes) {
	StatusEffectResult message = new StatusEffectResult();
	ProtobufIOUtil.mergeFrom(bytes, message, StatusEffectResult.getSchema());
	return message;
}

public static StatusEffectResult parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	StatusEffectResult message = new StatusEffectResult();
	JsonIOUtil.mergeFrom(bytes, message, StatusEffectResult.getSchema(), false);
	return message;
}

public StatusEffectResult clone() {
	byte[] bytes = this.toByteArray();
	StatusEffectResult statusEffectResult = StatusEffectResult.parseFrom(bytes);
	return statusEffectResult;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, StatusEffectResult.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<StatusEffectResult> schema = StatusEffectResult.getSchema();
    
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
		bytes = ProtobufIOUtil.toByteArray(this, StatusEffectResult.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

}
