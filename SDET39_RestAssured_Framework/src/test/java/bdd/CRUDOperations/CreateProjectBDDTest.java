package bdd.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectBDDTest {
@Test


public void createProject() {
	baseURI = "http://localhost";
	 port=8084;
	//System.out.println("I am inside method");
	 Random ran = new Random();
	 int random = ran.nextInt(500);
	
	//Create Pre requisite
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "Mahika1");
	obj.put("projectName", "SDET-29Online"+random);
	obj.put("status", "On Going");
	obj.put("teamSize", 20);
	
	//Send Request
	given()
	.body(obj)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
	
}
}
