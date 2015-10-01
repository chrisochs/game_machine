
package io.gamemachine.messages;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

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





import org.javalite.common.Convert;
import org.javalite.activejdbc.Model;
import io.protostuff.Schema;
import io.protostuff.UninitializedMessageException;



@SuppressWarnings("unused")
public final class ModelInfo implements Externalizable, Message<ModelInfo>, Schema<ModelInfo>{



    public static Schema<ModelInfo> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static ModelInfo getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final ModelInfo DEFAULT_INSTANCE = new ModelInfo();
    static final String defaultScope = ModelInfo.class.getSimpleName();

    			public Float attachX;
	    
        			public Float attachY;
	    
        			public Float attachZ;
	    
        			public Float rotateX;
	    
        			public Float rotateY;
	    
        			public Float rotateZ;
	    
        			public Float scaleX;
	    
        			public Float scaleY;
	    
        			public Float scaleZ;
	    
        			public String resource;
	    
        			public String prefab;
	    
        			public String weapon_type;
	    
        


    public ModelInfo()
    {
        
    }


	


	public static void clearModel(Model model) {
    	    	    	    	    	    	model.set("model_info_attach_x",null);
    	    	    	    	    	    	model.set("model_info_attach_y",null);
    	    	    	    	    	    	model.set("model_info_attach_z",null);
    	    	    	    	    	    	model.set("model_info_rotate_x",null);
    	    	    	    	    	    	model.set("model_info_rotate_y",null);
    	    	    	    	    	    	model.set("model_info_rotate_z",null);
    	    	    	    	    	    	model.set("model_info_scale_x",null);
    	    	    	    	    	    	model.set("model_info_scale_y",null);
    	    	    	    	    	    	model.set("model_info_scale_z",null);
    	    	    	    	    	    	model.set("model_info_resource",null);
    	    	    	    	    	    	model.set("model_info_prefab",null);
    	    	    	    	    	    	model.set("model_info_weapon_type",null);
    	    }
    
	public void toModel(Model model) {
    	    	    	    	
    	    	    	if (attachX != null) {
    	       	    	model.setFloat("model_info_attach_x",attachX);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (attachY != null) {
    	       	    	model.setFloat("model_info_attach_y",attachY);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (attachZ != null) {
    	       	    	model.setFloat("model_info_attach_z",attachZ);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (rotateX != null) {
    	       	    	model.setFloat("model_info_rotate_x",rotateX);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (rotateY != null) {
    	       	    	model.setFloat("model_info_rotate_y",rotateY);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (rotateZ != null) {
    	       	    	model.setFloat("model_info_rotate_z",rotateZ);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (scaleX != null) {
    	       	    	model.setFloat("model_info_scale_x",scaleX);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (scaleY != null) {
    	       	    	model.setFloat("model_info_scale_y",scaleY);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (scaleZ != null) {
    	       	    	model.setFloat("model_info_scale_z",scaleZ);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (resource != null) {
    	       	    	model.setString("model_info_resource",resource);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (prefab != null) {
    	       	    	model.setString("model_info_prefab",prefab);
    	        		
    	}
    	    	    	    	    	
    	    	    	if (weapon_type != null) {
    	       	    	model.setString("model_info_weapon_type",weapon_type);
    	        		
    	}
    	    	    }
    
	public static ModelInfo fromModel(Model model) {
		boolean hasFields = false;
    	ModelInfo message = new ModelInfo();
    	    	    	    	    	
    	    	    	Float attachXField = model.getFloat("model_info_attach_x");
    	    	
    	if (attachXField != null) {
    		message.setAttachX(attachXField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float attachYField = model.getFloat("model_info_attach_y");
    	    	
    	if (attachYField != null) {
    		message.setAttachY(attachYField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float attachZField = model.getFloat("model_info_attach_z");
    	    	
    	if (attachZField != null) {
    		message.setAttachZ(attachZField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float rotateXField = model.getFloat("model_info_rotate_x");
    	    	
    	if (rotateXField != null) {
    		message.setRotateX(rotateXField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float rotateYField = model.getFloat("model_info_rotate_y");
    	    	
    	if (rotateYField != null) {
    		message.setRotateY(rotateYField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float rotateZField = model.getFloat("model_info_rotate_z");
    	    	
    	if (rotateZField != null) {
    		message.setRotateZ(rotateZField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float scaleXField = model.getFloat("model_info_scale_x");
    	    	
    	if (scaleXField != null) {
    		message.setScaleX(scaleXField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float scaleYField = model.getFloat("model_info_scale_y");
    	    	
    	if (scaleYField != null) {
    		message.setScaleY(scaleYField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	Float scaleZField = model.getFloat("model_info_scale_z");
    	    	
    	if (scaleZField != null) {
    		message.setScaleZ(scaleZField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	String resourceField = model.getString("model_info_resource");
    	    	
    	if (resourceField != null) {
    		message.setResource(resourceField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	String prefabField = model.getString("model_info_prefab");
    	    	
    	if (prefabField != null) {
    		message.setPrefab(prefabField);
    		hasFields = true;
    	}
    	    	    	    	    	    	
    	    	    	String weapon_typeField = model.getString("model_info_weapon_type");
    	    	
    	if (weapon_typeField != null) {
    		message.setWeapon_type(weapon_typeField);
    		hasFields = true;
    	}
    	    	    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }


	    
    public Boolean hasAttachX()  {
        return attachX == null ? false : true;
    }
        
		public Float getAttachX() {
		return attachX;
	}
	
	public ModelInfo setAttachX(Float attachX) {
		this.attachX = attachX;
		return this;	}
	
		    
    public Boolean hasAttachY()  {
        return attachY == null ? false : true;
    }
        
		public Float getAttachY() {
		return attachY;
	}
	
	public ModelInfo setAttachY(Float attachY) {
		this.attachY = attachY;
		return this;	}
	
		    
    public Boolean hasAttachZ()  {
        return attachZ == null ? false : true;
    }
        
		public Float getAttachZ() {
		return attachZ;
	}
	
	public ModelInfo setAttachZ(Float attachZ) {
		this.attachZ = attachZ;
		return this;	}
	
		    
    public Boolean hasRotateX()  {
        return rotateX == null ? false : true;
    }
        
		public Float getRotateX() {
		return rotateX;
	}
	
	public ModelInfo setRotateX(Float rotateX) {
		this.rotateX = rotateX;
		return this;	}
	
		    
    public Boolean hasRotateY()  {
        return rotateY == null ? false : true;
    }
        
		public Float getRotateY() {
		return rotateY;
	}
	
	public ModelInfo setRotateY(Float rotateY) {
		this.rotateY = rotateY;
		return this;	}
	
		    
    public Boolean hasRotateZ()  {
        return rotateZ == null ? false : true;
    }
        
		public Float getRotateZ() {
		return rotateZ;
	}
	
	public ModelInfo setRotateZ(Float rotateZ) {
		this.rotateZ = rotateZ;
		return this;	}
	
		    
    public Boolean hasScaleX()  {
        return scaleX == null ? false : true;
    }
        
		public Float getScaleX() {
		return scaleX;
	}
	
	public ModelInfo setScaleX(Float scaleX) {
		this.scaleX = scaleX;
		return this;	}
	
		    
    public Boolean hasScaleY()  {
        return scaleY == null ? false : true;
    }
        
		public Float getScaleY() {
		return scaleY;
	}
	
	public ModelInfo setScaleY(Float scaleY) {
		this.scaleY = scaleY;
		return this;	}
	
		    
    public Boolean hasScaleZ()  {
        return scaleZ == null ? false : true;
    }
        
		public Float getScaleZ() {
		return scaleZ;
	}
	
	public ModelInfo setScaleZ(Float scaleZ) {
		this.scaleZ = scaleZ;
		return this;	}
	
		    
    public Boolean hasResource()  {
        return resource == null ? false : true;
    }
        
		public String getResource() {
		return resource;
	}
	
	public ModelInfo setResource(String resource) {
		this.resource = resource;
		return this;	}
	
		    
    public Boolean hasPrefab()  {
        return prefab == null ? false : true;
    }
        
		public String getPrefab() {
		return prefab;
	}
	
	public ModelInfo setPrefab(String prefab) {
		this.prefab = prefab;
		return this;	}
	
		    
    public Boolean hasWeapon_type()  {
        return weapon_type == null ? false : true;
    }
        
		public String getWeapon_type() {
		return weapon_type;
	}
	
	public ModelInfo setWeapon_type(String weapon_type) {
		this.weapon_type = weapon_type;
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

    public Schema<ModelInfo> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public ModelInfo newMessage()
    {
        return new ModelInfo();
    }

    public Class<ModelInfo> typeClass()
    {
        return ModelInfo.class;
    }

    public String messageName()
    {
        return ModelInfo.class.getSimpleName();
    }

    public String messageFullName()
    {
        return ModelInfo.class.getName();
    }

    public boolean isInitialized(ModelInfo message)
    {
        return true;
    }

    public void mergeFrom(Input input, ModelInfo message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                            	case 1:
            	                	                	message.attachX = input.readFloat();
                	break;
                	                	
                            	            	case 2:
            	                	                	message.attachY = input.readFloat();
                	break;
                	                	
                            	            	case 3:
            	                	                	message.attachZ = input.readFloat();
                	break;
                	                	
                            	            	case 4:
            	                	                	message.rotateX = input.readFloat();
                	break;
                	                	
                            	            	case 5:
            	                	                	message.rotateY = input.readFloat();
                	break;
                	                	
                            	            	case 6:
            	                	                	message.rotateZ = input.readFloat();
                	break;
                	                	
                            	            	case 7:
            	                	                	message.scaleX = input.readFloat();
                	break;
                	                	
                            	            	case 8:
            	                	                	message.scaleY = input.readFloat();
                	break;
                	                	
                            	            	case 9:
            	                	                	message.scaleZ = input.readFloat();
                	break;
                	                	
                            	            	case 10:
            	                	                	message.resource = input.readString();
                	break;
                	                	
                            	            	case 11:
            	                	                	message.prefab = input.readString();
                	break;
                	                	
                            	            	case 12:
            	                	                	message.weapon_type = input.readString();
                	break;
                	                	
                            	            
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, ModelInfo message) throws IOException
    {
    	    	
    	    	
    	    	    	if(message.attachX != null)
            output.writeFloat(1, message.attachX, false);
    	    	
    	            	
    	    	
    	    	    	if(message.attachY != null)
            output.writeFloat(2, message.attachY, false);
    	    	
    	            	
    	    	
    	    	    	if(message.attachZ != null)
            output.writeFloat(3, message.attachZ, false);
    	    	
    	            	
    	    	
    	    	    	if(message.rotateX != null)
            output.writeFloat(4, message.rotateX, false);
    	    	
    	            	
    	    	
    	    	    	if(message.rotateY != null)
            output.writeFloat(5, message.rotateY, false);
    	    	
    	            	
    	    	
    	    	    	if(message.rotateZ != null)
            output.writeFloat(6, message.rotateZ, false);
    	    	
    	            	
    	    	
    	    	    	if(message.scaleX != null)
            output.writeFloat(7, message.scaleX, false);
    	    	
    	            	
    	    	
    	    	    	if(message.scaleY != null)
            output.writeFloat(8, message.scaleY, false);
    	    	
    	            	
    	    	
    	    	    	if(message.scaleZ != null)
            output.writeFloat(9, message.scaleZ, false);
    	    	
    	            	
    	    	
    	    	    	if(message.resource != null)
            output.writeString(10, message.resource, false);
    	    	
    	            	
    	    	
    	    	    	if(message.prefab != null)
            output.writeString(11, message.prefab, false);
    	    	
    	            	
    	    	
    	    	    	if(message.weapon_type != null)
            output.writeString(12, message.weapon_type, false);
    	    	
    	            	
    }

	public void dumpObject()
    {
    	System.out.println("START ModelInfo");
    	    	if(this.attachX != null) {
    		System.out.println("attachX="+this.attachX);
    	}
    	    	if(this.attachY != null) {
    		System.out.println("attachY="+this.attachY);
    	}
    	    	if(this.attachZ != null) {
    		System.out.println("attachZ="+this.attachZ);
    	}
    	    	if(this.rotateX != null) {
    		System.out.println("rotateX="+this.rotateX);
    	}
    	    	if(this.rotateY != null) {
    		System.out.println("rotateY="+this.rotateY);
    	}
    	    	if(this.rotateZ != null) {
    		System.out.println("rotateZ="+this.rotateZ);
    	}
    	    	if(this.scaleX != null) {
    		System.out.println("scaleX="+this.scaleX);
    	}
    	    	if(this.scaleY != null) {
    		System.out.println("scaleY="+this.scaleY);
    	}
    	    	if(this.scaleZ != null) {
    		System.out.println("scaleZ="+this.scaleZ);
    	}
    	    	if(this.resource != null) {
    		System.out.println("resource="+this.resource);
    	}
    	    	if(this.prefab != null) {
    		System.out.println("prefab="+this.prefab);
    	}
    	    	if(this.weapon_type != null) {
    		System.out.println("weapon_type="+this.weapon_type);
    	}
    	    	System.out.println("END ModelInfo");
    }
    
    public String getFieldName(int number)
    {
        switch(number)
        {
        	        	case 1: return "attachX";
        	        	case 2: return "attachY";
        	        	case 3: return "attachZ";
        	        	case 4: return "rotateX";
        	        	case 5: return "rotateY";
        	        	case 6: return "rotateZ";
        	        	case 7: return "scaleX";
        	        	case 8: return "scaleY";
        	        	case 9: return "scaleZ";
        	        	case 10: return "resource";
        	        	case 11: return "prefab";
        	        	case 12: return "weapon_type";
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
    	    	__fieldMap.put("attachX", 1);
    	    	__fieldMap.put("attachY", 2);
    	    	__fieldMap.put("attachZ", 3);
    	    	__fieldMap.put("rotateX", 4);
    	    	__fieldMap.put("rotateY", 5);
    	    	__fieldMap.put("rotateZ", 6);
    	    	__fieldMap.put("scaleX", 7);
    	    	__fieldMap.put("scaleY", 8);
    	    	__fieldMap.put("scaleZ", 9);
    	    	__fieldMap.put("resource", 10);
    	    	__fieldMap.put("prefab", 11);
    	    	__fieldMap.put("weapon_type", 12);
    	    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = ModelInfo.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static ModelInfo parseFrom(byte[] bytes) {
	ModelInfo message = new ModelInfo();
	ProtobufIOUtil.mergeFrom(bytes, message, ModelInfo.getSchema());
	return message;
}

public static ModelInfo parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	ModelInfo message = new ModelInfo();
	JsonIOUtil.mergeFrom(bytes, message, ModelInfo.getSchema(), false);
	return message;
}

public ModelInfo clone() {
	byte[] bytes = this.toByteArray();
	ModelInfo modelInfo = ModelInfo.parseFrom(bytes);
	return modelInfo;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, ModelInfo.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<ModelInfo> schema = ModelInfo.getSchema();
    
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
		bytes = ProtobufIOUtil.toByteArray(this, ModelInfo.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

public ByteBuf toByteBuf() {
	ByteBuf bb = Unpooled.buffer(512, 2048);
	LinkedBuffer buffer = LinkedBuffer.use(bb.array());

	try {
		ProtobufIOUtil.writeTo(buffer, this, ModelInfo.getSchema());
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
