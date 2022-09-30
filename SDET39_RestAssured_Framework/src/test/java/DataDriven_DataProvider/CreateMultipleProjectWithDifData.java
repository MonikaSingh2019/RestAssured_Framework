package DataDriven_DataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CreateProjectUsingPOJOClass.ProjectLiberary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;


public class CreateMultipleProjectWithDifData {
@Test(dataProvider = "DataForPost")
public void createProjectWithDiffData(String createdBy, String projectName, String status, int teamSize) {
	baseURI = "http://localhost";
	port = 8084;
	
	//pre-requisite
	Random ran = new Random();
	int random = ran.nextInt(500);
	
	
	ProjectLiberary plib = new ProjectLiberary(createdBy, projectName+random, status, teamSize);
	
	given()
	.body(plib)
	.contentType(ContentType.JSON)
	
	//Actions to be performed
	.when()
	.post("/addProject")
	//Validation
	.then().log().all();
}
	@DataProvider(name="DataForPost")
	public Object[][] dataForPost()
	{
		Object[][] data = new Object[10][4];
		data[0][0] = "Odin";
		data[0][1] = "Glennfish";
		data[0][2] = "On Going";
		data[0][3] = 10;
		
		data[1][0] = "Alex";
		data[1][1] = "Demo";
		data[1][2] = "Created";
		data[1][3] = 15;
		
		data[2][0] = "Cortia";
		data[2][1] = "Windows";
		data[2][2] = "On Going";
		data[2][3] = 12;
		
		data[3][0] = "Levon";
		data[3][1] = "IPhone";
		data[3][2] = "Completed";
		data[3][3] = 5;
		
		data[4][0] = "Manisha";
		data[4][1] = "Lenovo";
		data[4][2] = "Created";
		data[4][3] = 20;
		
		data[5][0] = "Mehar";
		data[5][1] = "Acer";
		data[5][2] = "Completed";
		data[5][3] = 5;
		
		data[6][0] = "Alayna";
		data[6][1] = "Workstation";
		data[6][2] = "On Going";
		data[6][3] = 8;
		
		data[7][0] = "Aisha";
		data[7][1] = "UCB";
		data[7][2] = "Created";
		data[7][3] = 12;
		
		data[8][0] = "SnowBell";
		data[8][1] = "Sega";
		data[8][2] = "Completed";
		data[8][3] = 7;
		
		data[9][0] = "Iliana";
		data[9][1] = "Ford";
		data[9][2] = "On Going";
		data[9][3] = 20;
		return data;
		
	}
			
}
