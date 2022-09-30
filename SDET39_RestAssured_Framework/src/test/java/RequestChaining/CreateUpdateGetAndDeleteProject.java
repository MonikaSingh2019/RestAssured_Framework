package RequestChaining;
import CreateProjectUsingPOJOClass.ProjectLiberary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

public class CreateUpdateGetAndDeleteProject {
	@Test
	public void createUpdateGetAndDeleteProj() {
		
		Random ran = new Random();
		//Step1:Create pre requisite
		baseURI ="http://localhost";
		port=8084;
		ProjectLiberary plib = new ProjectLiberary("Isha", "IvyCare"+ran.nextInt(200), "Created", 15);
		
		
		//step2: send the post request
		Response resp = given()
				.body(plib)
				.contentType(ContentType.JSON)
				.when()
				.post("/addProject");
				
				
		//Step3: Capture the project ID writting Json Path
		
				String projectID = resp.jsonPath().getString("projectId");
				
				System.out.println(projectID);
				
				
		//Step4:Update project
				
		plib.setStatus("On Going");
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		.pathParam("pid", projectID)
		.when()
		.put("/projects/{pid}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
				
        //Step 5: Send the get request with Project ID
		given()
		 .pathParam("pid", projectID)
		.when()
		 .get("/projects/{pid}")
		 //.get("/projects/"+projectID)
         .then()
         .assertThat().statusCode(200).log().all();
		
		//Step5: Delete the created project
		given()
		.pathParam("pid", projectID)
		.when()
		.delete("projects/{pid}")
		.then()
		.assertThat().statusCode(204).log().all();			

		
}
}