package ResponseValidation;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGet {
	@Test
	public void staticResponseV() {
		//Step1:Create Pre-requisite
		String expData="TY_PROJ_1002";
		baseURI ="http://localhost";
		port=8084;
	    //action
		Response resp = when()
				.get("/projects");
				
		                   
		//validation
		
		String actData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		resp.then().log().all();
		
	}

}
