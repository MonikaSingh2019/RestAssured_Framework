package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	@Test

	public void pathParameter() {
		//Step1: create pre requisite
		baseURI ="http://reqres.in";
		
		
		//step2: send the request and validate the response
		given()
		.queryParam("page", 2)
		.when()
		.get("/api/users")
		.then()
		.assertThat().statusCode(200).log().all();
		
}
}