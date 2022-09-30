package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDser.EmpDetailsArray;

public class SerializationUsingArray {
	@Test
public static void serializationTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		int[] arr = {123,12345};
		EmpDetailsArray e2 = new EmpDetailsArray(2, "Monika", arr, "Banglore");
		
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File(".\\SampleArray.json"), e2);
	}

}
