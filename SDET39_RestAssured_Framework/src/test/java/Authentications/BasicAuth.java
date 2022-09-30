package Authentications;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuth {
	
	@Test
	public void basicAuthentication() {
		baseURI="http://localhost";	
		port=8084;
		//create pre requisite
		given()
		.auth()
		.basic("rmgyantra","rmgy@9999")
		.when()
		.get("/login")
		.then()
		.log().all();
	}
		
		@Test
		public void digestiveAuthentication() {
			baseURI="http://localhost";	
			port=8084;
			//create pre requisite
			given()
			.auth()
			.digest("rmgyantra","rmgy@9999")
			.when()
			.get("/login")
			.then()
			.log().all();

}
		
		
		@Test
		public void preemptiveAuthentication() {
			baseURI="http://localhost";	
			port=8084;
			//create pre requisite
			given()
			.auth()
			.preemptive().basic("rmgyantra","rmgy@9999")
			.when()
			.get("/login")
			.then()
			.log().all();

}
}
