package DifferentWaysToPOST;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObject {
	
@Test

public void createProject() {
	baseURI = "http://localhost";
	 port=8084;
	Random ran = new Random();
	int random = ran.nextInt(500);
	//create pre requiste
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "Angel");
	obj.put("projectName", "SDET"+random);
	obj.put("status", "On Going");
	obj.put("teamSize", 20);
	//send request
	given()
	.body(obj)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
}
}
