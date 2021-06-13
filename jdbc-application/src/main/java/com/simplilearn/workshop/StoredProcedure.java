package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StoredProcedure
 */
@WebServlet("/stored-procedure")
public class StoredProcedure extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Connection connection = MySqlDatabaseUtils.getConnection();
			
			String create_procedure = "create procedure show_customers ()"
					+ "BEGIN"
					+ " SELECT * FROM customer;"
					+ "END";
			
			
			//Statement statement = connection.createStatement();
			//statement.executeUpdate(create_procedure);
			
			CallableStatement callableStatement = connection.prepareCall("{call show_customers()}");
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			ResultSet resultSet = callableStatement.executeQuery();			
			while(resultSet.next()) {
				out.println(resultSet.getString("NAME") + "<br/>");
			}
			
			callableStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}
	}
}
