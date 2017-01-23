package com.hcl.utility;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;





@Service
public class CustomMessageConverters /* extends JsonDeserializer*/{
	Logger logger = LoggerFactory.getLogger(CustomMessageConverters.class);

	/* @Override
	 public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
	        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
	        String name = node.get("name").textValue();
	        int birth = node.get("category").intValue();
	        String aliveStr = node.get("alive").textValue();
	        return new (name, birth, Objects.equals(aliveStr, "T"));
	    }*/
/*
	@Override
	public Object deserialize(com.fasterxml.jackson.core.JsonParser jsonParser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {*/
		/*JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String name = node.get("name").textValue();
        int birth = node.get("category").intValue();
        String aliveStr = node.get("alive").textValue();
        return new CreatSite(name, birth, Objects.equals(aliveStr, "T"));*/
		
	/*	ObjectCodec oc = jsonParser.getCodec();
	    JsonNode node = oc.readTree(jsonParser);
	    final Long id = node.get("id").asLong();
	    final String name = node.get("name").asText();
	    final String contents = node.get("contents").asText();
	    final long ownerId = node.get("ownerId").asLong();
	    CreatSite user = new CreatSite();
	  
	    return user;
	    }*/
		
	

}
