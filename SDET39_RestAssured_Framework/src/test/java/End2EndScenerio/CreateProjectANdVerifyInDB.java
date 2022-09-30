package End2EndScenerio;

import org.testng.Assert;
import org.testng.annotations.Test;

import CreateProjectUsingPOJOClass.ProjectLiberary;
import GenericLibraries.BaseAPIClass;
import GenericLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectANdVerifyInDB extends BaseAPIClass {

	@Test
	
	public void createProject() throws SQLException
	{
		//Step1: Create pre requisites
		ProjectLiberary plib = new ProjectLiberary("Leno","Sdet39-Lenovo"+jlib.getRandomNumber(),"Created",12);
		
		
		//Step2: Send the request
		Response resp=given()
		 .body(plib)
		 .contentType(ContentType.JSON)
		 .when()
		 .post(EndPointsLibrary.createProject);
		
		//Step3: Capture the Project Id
		String expData = rlib.getJsonData(resp,"projectId");
		System.out.println(expData);
		
				
		//Step4: Verify the project ID in database
		String query = "select * from project";
		String actData =dblib.executeQueryandReturnData(query, 1, expData);
		Assert.assertEquals(actData, expData);	
		
	
	
	
	}
}
