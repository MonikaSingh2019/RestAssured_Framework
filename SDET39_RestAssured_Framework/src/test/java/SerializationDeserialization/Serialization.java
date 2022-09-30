package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDser.EmployeeDetails;

public class Serialization {
	@Test

	public void serializationTest() throws Throwable, IOException, Throwable {
	
		
		//Step1: Create Object of POJO Class
	EmployeeDetails emp = new EmployeeDetails("Monika", 12345, "TY123","monika@gmail.com", true);
	
	//Step2:Create Object of ObjectMapper from jacksonMapper-tool
	ObjectMapper obj = new ObjectMapper();
	
	//Step3: Call write value method and provide the file path
	//obj.writeValue(".\\Emp.json", emp);
	obj.writeValue(new File(".\\Emp.json"), emp);
	}
}
