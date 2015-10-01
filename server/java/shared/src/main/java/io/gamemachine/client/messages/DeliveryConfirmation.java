
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
public final class DeliveryConfirmation implements Externalizable, Message<DeliveryConfirmation>, Schema<DeliveryConfirmation>{



    public static Schema<DeliveryConfirmation> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static DeliveryConfirmation getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final DeliveryConfirmation DEFAULT_INSTANCE = new DeliveryConfirmation();

    			public String messageId;
	    
      
    public DeliveryConfirmation()
    {
        
    }


	

	    
    public Boolean hasMessageId()  {
        return messageId == null ? false : true;
    }
        
		public String getMessageId() {
		return messageId;
	}
	
	public DeliveryConfirmation setMessageId(String messageId) {
		this.messageId = messageId;
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

    public Schema<DeliveryConfirmation> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public DeliveryConfirmation newMessage()
    {
        return new DeliveryConfirmation();
    }

    public Class<DeliveryConfirmation> typeClass()
    {
        return DeliveryConfirmation.class;
    }

    public String messageName()
    {
        return DeliveryConfirmation.class.getSimpleName();
    }

    public String messageFullName()
    {
        return DeliveryConfirmation.class.getName();
    }

    public boolean isInitialized(DeliveryConfirmation message)
    {
        return true;
    }

    public void mergeFrom(Input input, DeliveryConfirmation message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                            	case 1:
            	                	                	message.messageId = input.readString();
                	break;
                	                	
                            	            
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, DeliveryConfirmation message) throws IOException
    {
    	    	
    	    	if(message.messageId == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.messageId != null)
            output.writeString(1, message.messageId, false);
    	    	
    	            	
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	        	case 1: return "messageId";
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
    	    	__fieldMap.put("messageId", 1);
    	    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = DeliveryConfirmation.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static DeliveryConfirmation parseFrom(byte[] bytes) {
	DeliveryConfirmation message = new DeliveryConfirmation();
	ProtobufIOUtil.mergeFrom(bytes, message, DeliveryConfirmation.getSchema());
	return message;
}

public static DeliveryConfirmation parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	DeliveryConfirmation message = new DeliveryConfirmation();
	JsonIOUtil.mergeFrom(bytes, message, DeliveryConfirmation.getSchema(), false);
	return message;
}

public DeliveryConfirmation clone() {
	byte[] bytes = this.toByteArray();
	DeliveryConfirmation deliveryConfirmation = DeliveryConfirmation.parseFrom(bytes);
	return deliveryConfirmation;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, DeliveryConfirmation.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<DeliveryConfirmation> schema = DeliveryConfirmation.getSchema();
    
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
		bytes = ProtobufIOUtil.toByteArray(this, DeliveryConfirmation.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

}
