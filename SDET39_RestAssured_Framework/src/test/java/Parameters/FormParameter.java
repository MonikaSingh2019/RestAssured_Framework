package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FormParameter {
	@Test
	public void pathParameter() {
		//Step1: create pre requisite
		baseURI ="http://localhost";
		port=8084;
		
		//step2: send the request and validate the response
		given()
		.formParam("createdBy", "OMG")
		.formParam("projectName", "SnowWhite")
		.formParam("status", "Completed")
		.formParam("teamSize", 20)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all();
		
	}
}
