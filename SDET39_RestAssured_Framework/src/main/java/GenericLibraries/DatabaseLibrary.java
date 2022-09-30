package GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseLibrary {
	Driver driverRef;
	Connection con;
public void connectToDB() throws SQLException {
driverRef=new Driver();
DriverManager.registerDriver(driverRef);
con=DriverManager.getConnection(IConstantLibrary.dbURL, IConstantLibrary.dbUsername, IConstantLibrary.dbPassword);
}
/**
 * This method will close the database connection
 * @throws SQLException 
 */
public void closeDb() throws SQLException {
	con.close();
}

/**
 * This method will execute a query,fetch the data and verify the data in database with exp data from the caller
 * @param query
 * @param columnIndex
 * @param expData
 */
public String executeQueryandReturnData(String query,int columnIndex,String expData) throws SQLException{
	ResultSet result=con.createStatement().executeQuery(query);
    boolean flag=false;
	while(result.next()) 
    {
       String actData =	result.getString(columnIndex);
    
    
       if(expData.equalsIgnoreCase(actData))
    	{
    	flag=true;
    	break;
    	
    	}
    	}
	if(flag)
	{
		System.out.println("the data is verified ");
	    return expData;
	}
	else 
	{
		System.out.println("The data is not verified");
		return " ";
	}

}
}
