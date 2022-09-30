package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDser.EmpDetailsArray;




public class DeserializationUsingArray 
{
	@Test
	public void deserializationTest() throws Throwable, JsonMappingException, IOException {
	ObjectMapper obj = new ObjectMapper(); 
	EmpDetailsArray emp = obj.readValue(new File(".\\SampleArray.json"), EmpDetailsArray.class);
	System.out.println(emp.getName());
}
}