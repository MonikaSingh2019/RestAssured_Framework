package Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PathParameterTest {
@Test
public void pathParameter() {
	//Step1: create pre requisite
	baseURI ="http://localhost";
	port=8084;
	
	//step2: send the request and validate the response
	given()
	.pathParam("pid", "TY_PROJ_1002")
	.when()
	//.get("/projects/{pid}")
	.delete("/projects/{pid}")
	.then()
	//.assertThat().statusCode(200).log().all();
	.assertThat().statusCode(204).log().all();
	}
}

