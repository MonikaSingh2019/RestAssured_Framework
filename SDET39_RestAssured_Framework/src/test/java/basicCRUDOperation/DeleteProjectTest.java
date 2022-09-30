package basicCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
@Test

public void deleteProject() {
	
	//Step1: create pre prerequites
	
	
	//Step2: Send the request
	Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1402");
	
	
	//Step3: validate the response
	System.out.println(resp.getStatusCode());
}
}
