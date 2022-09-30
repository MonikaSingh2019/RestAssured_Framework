package Authentications;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ouath2Authentication {
@Test

public void oauth2Auth() {
	//Step1: Generate the access Token -Post
	baseURI="http://coop.apps.symfonycasts.com";
	
			
	Response resp = given()
	.formParam("client_id", "SDET39-RESTAssure")
	.formParam("client_secret","2357c7d161e3b68cfcb987f623365b88")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://example.com")
	.formParam("code", "authorization_code")
	.when()
	.post("/token");
	
	//Step2: Capture the token
	 String token =resp.jsonPath().get("access_token");
	//Step3: Use it for other  endpoints
	 given()
	 .pathParam("USER_ID",3844)
	 .auth()
	 .oauth2(token)
	 .when()
	 .post("/api/{USER_ID}/eggs-collect")
	 .then().log().all();
}
}
