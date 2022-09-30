package End2EndScenerio;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import CreateProjectUsingPOJOClass.ProjectLiberary;
import GenericLibraries.BaseAPIClass;
import GenericLibraries.BaseApiClassWithSpecBuilders;
import GenericLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class CreateE2EUsingSpecBuild extends BaseApiClassWithSpecBuilders {
@Test
	
	public void createProject() throws SQLException
	{
		//Step1: Create pre requisites
		ProjectLiberary plib = new ProjectLiberary("Ishi","Sdet39-Lenovo"+jlib.getRandomNumber(),"Created",12);
		
		
		//Step2: Send the request
		Response resp=given()
		              .spec(requestSpec)
		              .body(plib)
		              .when()
		              .post(EndPointsLibrary.createProject);
		               resp.then().log().all();
		               
		//Step3: Capture the Project Id
		String expData = rlib.getJsonData(resp,"projectId");
		System.out.println(expData);
		
				
		//Step4: Verify the project ID in database
		String query = "select * from project";
		String actData =dblib.executeQueryandReturnData(query, 1, expData);
		Assert.assertEquals(actData, expData);	
		
}
}