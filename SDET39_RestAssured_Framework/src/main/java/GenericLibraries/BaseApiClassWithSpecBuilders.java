package GenericLibraries;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiClassWithSpecBuilders {
	public DatabaseLibrary dblib = new DatabaseLibrary();
	public JavaLibrary jlib = new JavaLibrary();
	public RestAssuredLibrary rlib = new RestAssuredLibrary();
	public RequestSpecification requestSpec;
	public ResponseSpecBuilder responseSpec;
	@BeforeSuite
	
	public void bsConfig() throws SQLException
	{
		
		dblib.connectToDB();
		Reporter.log("====db connection successful====", true);
	    //Request builder is a class in rest assured library used to store all the common actions related to request
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(IConstantLibrary.appURL);
		builder.setPort(IConstantLibrary.appPort);
		builder.setContentType(ContentType.JSON);
		
		requestSpec = builder.build();
	}

	@AfterSuite
	public void asConfig() throws SQLException
	{
		dblib.closeDb();
		Reporter.log("====db closed====", true);
		//Response spec builder is a class in rest Assured library used to store all common actions related to response
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
	    responseSpec = builder.log(null);
	}
}
