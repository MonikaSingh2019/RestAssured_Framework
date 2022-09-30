package ResponseValidation;
import static io.restassured.RestAssured.port;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class DynamicResponseValidation {
	@Test
	
	public void  dynamicResponseV() {
		
		baseURI="http://localhost";
		port=8084;
		String expData="TY_PROJ_2402";
		//Send Request
		Response resp = when()
				        .get("/projects");
		
		//Step3: Validate the Response
		
		boolean flag = false;
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData:list)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				System.out.println(actData);
				flag = true; //flag rising
				break;
				
			}
		}
		Assert.assertTrue(flag);	
	}

}
