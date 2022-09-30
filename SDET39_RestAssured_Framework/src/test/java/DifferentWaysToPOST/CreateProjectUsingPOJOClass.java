package DifferentWaysToPOST;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import CreateProjectUsingPOJOClass.ProjectLiberary;
import io.restassured.http.ContentType;


public class CreateProjectUsingPOJOClass {
	@Test
	public void createProject()
	{
		
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites
		Random ran = new Random();
		int random = ran.nextInt(500);
		ProjectLiberary pLib = new ProjectLiberary("Banty", "GoogleMeet"+random,"Created", 10);
		
		given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		.when()                          //Step 2: perform action
		 .post("/addProject")
		.then()                          //Step 3: validation
		 .assertThat().statusCode(201)
		 .log().all();
		
		
		
	}
}
