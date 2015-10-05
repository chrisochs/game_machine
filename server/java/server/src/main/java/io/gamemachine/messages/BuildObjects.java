
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
public final class BuildObjects implements Externalizable, Message<BuildObjects>, Schema<BuildObjects>{



    public static Schema<BuildObjects> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static BuildObjects getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final BuildObjects DEFAULT_INSTANCE = new BuildObjects();
    static final String defaultScope = BuildObjects.class.getSimpleName();

        public List<BuildObject> buildObject;
	    	
	    	    public int action= 0;
	    		
    
        	
	    	    public int requestedUpdateId= 0;
	    		
    
        	
	    	    public int currentUpdate= 0;
	    		
    
        


    public BuildObjects()
    {
        
    }


	


	public static void clearModel(Model model) {
    	    	    	    	    	    	    	model.set("build_objects_action",null);
    	    	    	    	    	    	model.set("build_objects_requested_update_id",null);
    	    	    	    	    	    	model.set("build_objects_current_update",null);
    	    }
    
	public void toModel(Model model) {
    	    	    	    	    	
    	    	    	//if (action != null) {
    	       	    	model.setInteger("build_objects_action",action);
    	        		
    	//}
    	    	    	    	    	
    	    	    	//if (requestedUpdateId != null) {
    	       	    	model.setInteger("build_objects_requested_update_id",requestedUpdateId);
    	        		
    	//}
    	    	    	    	    	
    	    	    	//if (currentUpdate != null) {
    	       	    	model.setInteger("build_objects_current_update",currentUpdate);
    	        		
    	//}
    	    	    }
    
	public static BuildObjects fromModel(Model model) {
		boolean hasFields = false;
    	BuildObjects message = new BuildObjects();
    	    	    	    	    	    	
    	    	    	Integer actionTestField = model.getInteger("build_objects_action");
    	if (actionTestField != null) {
    		int actionField = actionTestField;
    		message.setAction(actionField);
    		hasFields = true;
    	}
    	
    	    	
    	    	    	    	    	    	
    	    	    	Integer requestedUpdateIdTestField = model.getInteger("build_objects_requested_update_id");
    	if (requestedUpdateIdTestField != null) {
    		int requestedUpdateIdField = requestedUpdateIdTestField;
    		message.setRequestedUpdateId(requestedUpdateIdField);
    		hasFields = true;
    	}
    	
    	    	
    	    	    	    	    	    	
    	    	    	Integer currentUpdateTestField = model.getInteger("build_objects_current_update");
    	if (currentUpdateTestField != null) {
    		int currentUpdateField = currentUpdateTestField;
    		message.setCurrentUpdate(currentUpdateField);
    		hasFields = true;
    	}
    	
    	    	
    	    	    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }


	            
		public List<BuildObject> getBuildObjectList() {
		if(this.buildObject == null)
            this.buildObject = new ArrayList<BuildObject>();
		return buildObject;
	}

	public BuildObjects setBuildObjectList(List<BuildObject> buildObject) {
		this.buildObject = buildObject;
		return this;
	}

	public BuildObject getBuildObject(int index)  {
        return buildObject == null ? null : buildObject.get(index);
    }

    public int getBuildObjectCount()  {
        return buildObject == null ? 0 : buildObject.size();
    }

    public BuildObjects addBuildObject(BuildObject buildObject)  {
        if(this.buildObject == null)
            this.buildObject = new ArrayList<BuildObject>();
        this.buildObject.add(buildObject);
        return this;
    }
            	    	    	    	
    public BuildObjects removeBuildObjectByPlayerItemId(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.playerItemId.equals(obj.playerItemId)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByAction(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.action == obj.action) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectById(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.id.equals(obj.id)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByRecordId(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.recordId == obj.recordId) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByOwnerId(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.ownerId.equals(obj.ownerId)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByX(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.x == obj.x) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByY(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.y == obj.y) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByZ(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.z == obj.z) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByRx(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.rx == obj.rx) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByRy(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.ry == obj.ry) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByRz(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.rz == obj.rz) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByRw(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.rw == obj.rw) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByHealth(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.health == obj.health) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByTemplateId(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.templateId == obj.templateId) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByGrid(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.grid.equals(obj.grid)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByUpdatedAt(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.updatedAt == obj.updatedAt) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByState(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.state == obj.state) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByUpdateId(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.updateId == obj.updateId) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByIsFloor(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.isFloor == obj.isFloor) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByIsDestructable(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.isDestructable == obj.isDestructable) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByHasDoor(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.hasDoor == obj.hasDoor) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByDoorStatus(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.doorStatus == obj.doorStatus) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByGroundBlockObject(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.groundBlockObject == obj.groundBlockObject) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByIsGroundBlock(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.isGroundBlock == obj.isGroundBlock) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByChunk(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.chunk == obj.chunk) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByTerrainEdit(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.terrainEdit == obj.terrainEdit) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByIsTerrainEdit(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.isTerrainEdit == obj.isTerrainEdit) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByCustomBytes(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.customBytes == obj.customBytes) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByCustomString(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.customString.equals(obj.customString)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByTextureId(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.textureId.equals(obj.textureId)) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectBySlots(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.slots == obj.slots) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	    	    	    	
    public BuildObjects removeBuildObjectByPlacedAt(BuildObject buildObject)  {
    	if(this.buildObject == null)
           return this;
            
       	Iterator<BuildObject> itr = this.buildObject.iterator();
       	while (itr.hasNext()) {
    	BuildObject obj = itr.next();
    	
    	    		if (buildObject.placedAt == obj.placedAt) {
    	      			itr.remove();
    		}
		}
        return this;
    }
    
        	        	
    
    
    
		            
		public int getAction() {
		return action;
	}
	
	public BuildObjects setAction(int action) {
		this.action = action;
		return this;	}
	
		            
		public int getRequestedUpdateId() {
		return requestedUpdateId;
	}
	
	public BuildObjects setRequestedUpdateId(int requestedUpdateId) {
		this.requestedUpdateId = requestedUpdateId;
		return this;	}
	
		            
		public int getCurrentUpdate() {
		return currentUpdate;
	}
	
	public BuildObjects setCurrentUpdate(int currentUpdate) {
		this.currentUpdate = currentUpdate;
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

    public Schema<BuildObjects> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public BuildObjects newMessage()
    {
        return new BuildObjects();
    }

    public Class<BuildObjects> typeClass()
    {
        return BuildObjects.class;
    }

    public String messageName()
    {
        return BuildObjects.class.getSimpleName();
    }

    public String messageFullName()
    {
        return BuildObjects.class.getName();
    }

    public boolean isInitialized(BuildObjects message)
    {
        return true;
    }

    public void mergeFrom(Input input, BuildObjects message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                            	case 1:
            	            		if(message.buildObject == null)
                        message.buildObject = new ArrayList<BuildObject>();
                                        message.buildObject.add(input.mergeObject(null, BuildObject.getSchema()));
                                        break;
                            	            	case 2:
            	                	                	message.action = input.readInt32();
                	break;
                	                	
                            	            	case 3:
            	                	                	message.requestedUpdateId = input.readInt32();
                	break;
                	                	
                            	            	case 4:
            	                	                	message.currentUpdate = input.readInt32();
                	break;
                	                	
                            	            
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, BuildObjects message) throws IOException
    {
    	    	
    	    	
    	    	if(message.buildObject != null)
        {
            for(BuildObject buildObject : message.buildObject)
            {
                if( (BuildObject) buildObject != null) {
                   	    				output.writeObject(1, buildObject, BuildObject.getSchema(), true);
    				    			}
            }
        }
    	            	
    	    	
    	    	    	if( (Integer)message.action != null) {
            output.writeInt32(2, message.action, false);
        }
    	    	
    	            	
    	    	
    	    	    	if( (Integer)message.requestedUpdateId != null) {
            output.writeInt32(3, message.requestedUpdateId, false);
        }
    	    	
    	            	
    	    	
    	    	    	if( (Integer)message.currentUpdate != null) {
            output.writeInt32(4, message.currentUpdate, false);
        }
    	    	
    	            	
    }

	public void dumpObject()
    {
    	System.out.println("START BuildObjects");
    	    	//if(this.buildObject != null) {
    		System.out.println("buildObject="+this.buildObject);
    	//}
    	    	//if(this.action != null) {
    		System.out.println("action="+this.action);
    	//}
    	    	//if(this.requestedUpdateId != null) {
    		System.out.println("requestedUpdateId="+this.requestedUpdateId);
    	//}
    	    	//if(this.currentUpdate != null) {
    		System.out.println("currentUpdate="+this.currentUpdate);
    	//}
    	    	System.out.println("END BuildObjects");
    }
    
    public String getFieldName(int number)
    {
        switch(number)
        {
        	        	case 1: return "buildObject";
        	        	case 2: return "action";
        	        	case 3: return "requestedUpdateId";
        	        	case 4: return "currentUpdate";
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
    	    	__fieldMap.put("buildObject", 1);
    	    	__fieldMap.put("action", 2);
    	    	__fieldMap.put("requestedUpdateId", 3);
    	    	__fieldMap.put("currentUpdate", 4);
    	    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = BuildObjects.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static BuildObjects parseFrom(byte[] bytes) {
	BuildObjects message = new BuildObjects();
	ProtobufIOUtil.mergeFrom(bytes, message, BuildObjects.getSchema());
	return message;
}

public static BuildObjects parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	BuildObjects message = new BuildObjects();
	JsonIOUtil.mergeFrom(bytes, message, BuildObjects.getSchema(), false);
	return message;
}

public BuildObjects clone() {
	byte[] bytes = this.toByteArray();
	BuildObjects buildObjects = BuildObjects.parseFrom(bytes);
	return buildObjects;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, BuildObjects.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<BuildObjects> schema = BuildObjects.getSchema();
    
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
		bytes = ProtobufIOUtil.toByteArray(this, BuildObjects.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed "+e.getMessage());
	}
	return bytes;
}

public ByteBuf toByteBuf() {
	ByteBuf bb = Unpooled.buffer(512, 2048);
	LinkedBuffer buffer = LinkedBuffer.use(bb.array());

	try {
		ProtobufIOUtil.writeTo(buffer, this, BuildObjects.getSchema());
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed "+e.getMessage());
	}
	return bb;
}

}
