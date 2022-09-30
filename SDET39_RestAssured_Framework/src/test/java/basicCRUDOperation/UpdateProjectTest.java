package basicCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test 
	public void updateProject() {
		//Step1: Create pre Requisite
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Ilisha2019");
		obj.put("projectName", "Forza crm");
		obj.put("status", "Completed");
		obj.put("teamSize", 10);
		
		
		//Step2: Send the request
		
				RequestSpecification request = RestAssured.given();
				request.body(obj);
				request.contentType(ContentType.JSON);
				Response resp = request.put("http://localhost:8084/projects/TY_PROJ_1402");
				
				//Step3: Validate the response
				
				System.out.println(resp.getStatusCode());
				
	}

}
