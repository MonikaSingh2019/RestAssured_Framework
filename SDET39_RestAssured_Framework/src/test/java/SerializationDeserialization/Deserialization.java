package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDser.EmployeeDetails;

public class Deserialization {
@Test
public void deserializationTest() throws Throwable, JsonMappingException, IOException {
	//Step1: Create Object of Object Mapper
	ObjectMapper obj = new ObjectMapper(); 
	
	
	//Step2: Read value from Object Mapper class
	EmployeeDetails emp = obj.readValue(new File(".\\Emp.json"), EmployeeDetails.class);
	
	//Step3: Access the value using reference
	System.out.println(emp.getEmail());
	emp.setName("SDET");
	
	
	
	
}
}
