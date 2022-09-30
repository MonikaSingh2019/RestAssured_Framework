package bdd.CRUDOperations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteOperationUsingBdd {
@Test
public void deleteProjectUsingBdd() {
	baseURI = "http://localhost";
	 port=8084;
	//create request
	
	//send request
	when()
	.delete("/projects/TY_PROJ_1006")
	.then()
	.assertThat().statusCode(204)
	.log().all();
}
}

