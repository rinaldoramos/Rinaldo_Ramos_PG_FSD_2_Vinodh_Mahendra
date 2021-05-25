package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select-sql")
public class SelectSQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SELECT_SQL = "SELECT * FROM customer";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//initialize the database
		try {
			// step #1	:	initialize the database
			Connection connection = MySqlDatabaseUtils.getConnection();
			
			// step #2	:	Obtain a statement object from connection
			Statement statement = connection.createStatement();
			
			// Step #3	: Execute query and saved it on a ResultSet object
			ResultSet resultSet = statement.executeQuery(SELECT_SQL);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='center'>");
			
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Phone</th>");
			out.println("</tr>");
			
			// Step #4	:	Traverse the ResultSet and print the values
			while(resultSet.next()) {
				
				out.println("<tr>");
				out.println("<td>" + resultSet.getInt("id") + "</td>");
				out.println("<td>" + resultSet.getString("name") + "</td>");
				out.println("<td>" + resultSet.getString("email") + "</td>");
				out.println("<td>" + resultSet.getString("phone") + "</td>");
				out.println("</tr>");
			}
			
			// Step #5	:	Close your resultSet, statement and connection
			resultSet.close();
			statement.close();
			connection.close();
			
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
