package com.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {
	private PreparedStatement preparedStatement = null;
	public DBConnect() throws SQLException
	{
	String connectionURL = "jdbc:mysql://localhost:3306/jwt"+"user=root&password=pajisingh";
	
	    // Load the Driver class. 
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			// If you are using any other database then load the right driver here.
			 
		    //Create the connection using the static getConnection method
		    Connection con = DriverManager.getConnection (connectionURL);
		 
		    //Create a Statement class to execute the SQL statement
		    Statement stmt = con.createStatement();
		 
		    //Execute the SQL statement and get the results in a Resultset
		    preparedStatement = con
		    		.prepareStatement("insert into  user values (?, ?, ? , ?, ?)");
	        // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
	        // Parameters start with 1
	        preparedStatement.setString(1, "Test");
	        preparedStatement.setString(2, "TestEmail");
	        preparedStatement.setString(3, "TestWebpage");
	        preparedStatement.setString(4, "sjjkqsjk");
	        preparedStatement.setString(5, "TestSummary");
		        preparedStatement.executeUpdate();
		 
		   
		    con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
