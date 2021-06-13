package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

import com.mysql.cj.xdevapi.PreparableStatement;

@WebServlet("/insert-data")
public class InsertSQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Read the parameters from request
	
		String name = request.getParameter("NAME");
		String email = request.getParameter("EMAIL");
		String phone = request.getParameter("PHONE");
		
		
		try {
			// Initialize the database
			Connection connection = MySqlDatabaseUtils.getConnection();
			
			String INSERT_SQL = "insert into customer (name, email, phone) values (?,?,?)"; // This is called Dynamic Query
			
			//Create a Prepared Statement
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, phone);
			
			preparedStatement.executeUpdate();
			
			response.setContentType("text/html");
			
			preparedStatement.close();
			connection.close();
			
			PrintWriter out = response.getWriter();
			out.println("<h3>Successfully Inserted</3>");
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO: handle exception
		}
		
		
	}

}
