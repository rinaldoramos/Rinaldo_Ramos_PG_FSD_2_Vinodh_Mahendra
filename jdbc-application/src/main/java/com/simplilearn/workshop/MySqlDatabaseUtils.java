package com.simplilearn.workshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabaseUtils {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pgfsd?useSSL=false"; //change it
		String user = "root";
		String password = "admin";
		// Step #1	:	load driver
		Class.forName(driverClassName);		
		// Step #2	:	obtain a connection using DriverManager
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

}
