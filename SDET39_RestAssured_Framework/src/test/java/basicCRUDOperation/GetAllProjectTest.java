package basicCRUDOperation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectTest {

	@Test
	public void getAllProjects()
	{
		
		//Step1: create prerequisite
		
		
		//Step2: send the request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//Step3: Validate the response
		int expStatus=200;
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, expStatus);
		System.out.println(resp.getStatusCode());
		
		
	}
}
