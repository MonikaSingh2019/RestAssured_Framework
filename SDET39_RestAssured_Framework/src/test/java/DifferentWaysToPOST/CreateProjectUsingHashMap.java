package DifferentWaysToPOST;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {
	@Test

	public void createProject() {
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites 
		Random ran = new Random();
		int random = ran.nextInt(500);
		//create pre requiste
		HashMap map= new HashMap();
		map.put("createdBy", "Angel");
		map.put("projectName", "SDET"+random);
		map.put("status", "On Going");
		map.put("teamSize", 20);
		//send request
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
}
}