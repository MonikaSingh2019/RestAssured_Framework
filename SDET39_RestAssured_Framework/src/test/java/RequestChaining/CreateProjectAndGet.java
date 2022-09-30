package RequestChaining;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import CreateProjectUsingPOJOClass.ProjectLiberary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class CreateProjectAndGet {
	@Test
	public void createAndGet() {
		Random ran = new Random();
		//Step1:Create pre requisite
		baseURI ="http://localhost";
		port=8084;
		
		ProjectLiberary plib = new ProjectLiberary("Monikka", "Amdocs"+ran.nextInt(200), "Created", 5);
		
		
		//step2: send the post request
		Response resp = given()
				        .body(plib)
				        .contentType(ContentType.JSON)
				        .when()
				        .post("/addProject");
		
		//Step3: Capture the project ID writting Json Path
		String projectID = resp.jsonPath().getString("projectId");
		
		System.out.println(projectID);
				
		//Step 4: Send the get request with Project ID
		given()
		 .pathParam("pid", projectID)
		.when()
		 .get("/projects/{pid}")
		 //.get("/projects/"+projectID)
         .then()
         .assertThat().statusCode(200).log().all();
		
		
		
	
		
		
	}
	

}
