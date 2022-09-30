package bdd.CRUDOperations;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.Random;
import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectBddTest {
@Test
public void updateProject() {
	baseURI = "http://localhost";
	 port=8084;
	//System.out.println("I am inside method");
	 Random ran = new Random();
	 int random = ran.nextInt(500);
	
	//Create Pre requisite
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "Mahika1");
	obj.put("projectName", "SDET39-283");
	obj.put("status", "Completed");
	obj.put("teamSize", 15);
	
	//Send Request
	
	given()
	.body(obj)
	.contentType(ContentType.JSON)
	.when()
	.put("/projects/TY_PROJ_1006")
	.then()
	.assertThat().statusCode(200)
	.log().all();
	 
	
}
}
