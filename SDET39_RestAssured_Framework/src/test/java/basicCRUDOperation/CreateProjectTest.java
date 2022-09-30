package basicCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void createProjectTest() {
		//Step1: Create the prerequisites necessary
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Ilisha2019");
		obj.put("projectName", "Forza");
		obj.put("status", "On Going");
		obj.put("teamSize", 10);
		
		
		//Step2: Send the request
		
		RequestSpecification request = RestAssured.given();
		request.body(obj);
		request.contentType(ContentType.JSON);
		Response resp = request.post("http://localhost:8084/addProject");
		
		//Step3:Validate the response
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getTime());
		
		System.out.println(resp.asPrettyString());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.prettyPrint());
		
		
	}
	

}
