package GenericLibraries;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

/**
 * This class will contains basic configuration annotations
 * @author Monika
 *
 */
public class BaseAPIClass {
	public DatabaseLibrary dblib = new DatabaseLibrary();
	public JavaLibrary jlib = new JavaLibrary();
	public RestAssuredLibrary rlib = new RestAssuredLibrary();
	
	@BeforeSuite
	
	public void bsConfig() throws SQLException
	{
		
		dblib.connectToDB();
		Reporter.log("====db connection successful====", true);
	    baseURI = IConstantLibrary.appURL;
		port=IConstantLibrary.appPort;
		
		
	}

	@AfterSuite
	public void asConfig() throws SQLException
	{
		dblib.closeDb();
		Reporter.log("====db closed====", true);
	}
}
