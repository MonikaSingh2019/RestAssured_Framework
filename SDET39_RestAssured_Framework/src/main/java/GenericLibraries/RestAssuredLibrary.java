package GenericLibraries;

import io.restassured.response.Response;

/**
 * This class consists of generic methods related to Rest Assured
 *
 
 * @author Lenovo
 *
 */
public class RestAssuredLibrary {
	
	public String getJsonData(Response response, String path){
	String jsonData = response.jsonPath().get(path);	
		
		return jsonData;
		
	}
	{
		
		
		
	}

}
