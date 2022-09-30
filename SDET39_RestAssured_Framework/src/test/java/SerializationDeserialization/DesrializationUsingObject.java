package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDser.EmpDetailsObject;
import practice_POJO_SerDser.Spouse;

public class DesrializationUsingObject {
	
		@Test
		public void deserializationTest() throws Throwable, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper(); 
		EmpDetailsObject s1 = obj.readValue(new File(".\\SampleArray.json"), EmpDetailsObject.class);
		System.out.println(s1.getAddress());
		System.out.println(s1.getSpouse());
		
	}
}
