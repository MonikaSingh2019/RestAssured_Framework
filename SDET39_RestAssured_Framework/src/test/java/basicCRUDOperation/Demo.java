package basicCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {
	@Test
	public void createproject()
		{
	  // step:1 create prerequesites necessary
		
		JSONObject obj=new JSONObject();
		
		obj.put("createdBy", "Muneera");
		obj.put("projectName", "estAssured");
		obj.put("status", "On Going");
		obj.put("teamSize", 12);
		
		//step2: send the request
		
		RequestSpecification request = RestAssured.given();
		request.body(obj);
		
		request.contentType(ContentType.JSON);//enum block 
		
		Response resp = request.post("http://localhost:8084/addProject");
		
		//step 3: validate the response
		System.out.println(resp.contentType());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.prettyPrint());//response body json objec twice
		System.out.println(resp.getStatusLine());
		System.out.println(resp.prettyPeek());//the heder and responsebody preferable
		System.out.println(resp.asString());
		
		System.out.println(resp.then());//validatable response
		
		//System.out.println(resp.log().all());
		
		
		
		
		
		
		
	}

}
