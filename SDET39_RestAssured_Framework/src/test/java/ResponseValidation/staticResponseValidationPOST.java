package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class staticResponseValidationPOST {
@Test
public void createProjectResponseV() {
	
	baseURI = "http://localhost";
	 port=8084;
	//System.out.println("I am inside method");
	 Random ran = new Random();
	 int random = ran.nextInt(500);
	
	//Create Pre requisite
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "Mahika1");
	obj.put("projectName", "OlayIndia");
	obj.put("status", "On Going");
	obj.put("teamSize", 20);
	String expData="OlayIndia";
	//Send Request
	Response resp = given()
			        .body(obj)
			        .contentType(ContentType.JSON)
			        .when()
			        .post("/addProject");
	
	
	//validation
	
			String actData = resp.jsonPath().get("projectName");
			Assert.assertEquals(actData, expData);
			System.out.println("data varified");
			resp.then().log().all();
			
}
}
