package Authentications;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BearerToken {
	@Test
	public void bearerToken() {
		baseURI="https://api.github.com";
		JSONObject obj = new JSONObject();
		obj.put("name", "Sdet-REST");
		obj.put("description", "HybridFW");
		given()
		.auth()
		.oauth2("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")
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")
		.then().log().all();
	}

}
