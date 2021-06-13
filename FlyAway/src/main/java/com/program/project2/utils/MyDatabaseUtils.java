package com.program.project2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabaseUtils {
	
	public static Connection getConnection()throws SQLException, ClassNotFoundException{
		
		// defining the driverClass object
		String mySqlDriver = "com.mysql.cj.jdbc.Driver";		
		// defining the URL
		String url = "jdbc:mysql://localhost:3306/flyaway-db?useSSL=false";
		// defining the user
		String user = "root";
		// defining the password
		String password = "admin";
		
		// loading the driver
		Class.forName(mySqlDriver);
		
		// making a connection using the DriverManager class
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// returning the connection
		return connection;
	}

}
