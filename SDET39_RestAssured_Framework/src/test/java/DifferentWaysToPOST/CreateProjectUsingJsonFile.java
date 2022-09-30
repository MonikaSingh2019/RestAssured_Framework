package DifferentWaysToPOST;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


public class CreateProjectUsingJsonFile {
	@Test
	public void createProject()
	{
		//Step 1: create pre requisites
		File file = new File(".\\Data.json");
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		 .body(file)
		 .contentType(ContentType.JSON)
		.when()                        //Step 2: perform Action
		 .post("/addProject")
		.then()                       //Step 3: Validation
		 .assertThat().statusCode(201)
		 .log().all();
	
	}

}
