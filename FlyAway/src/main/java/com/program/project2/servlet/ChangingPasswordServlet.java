package com.program.project2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Result;
import com.program.project2.utils.MyDatabaseUtils;

/**
 * Servlet implementation class ChangingPasswordServlet
 */
@WebServlet("/ChangingPasswordServlet")
public class ChangingPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangingPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("uname");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		int id = 0;

		System.out.println(firstName);
		System.out.println(newPassword);

		out.println("<h2>Changing password now...</h2><br/><br/>");

		try {
			// Establishing the connection
			Connection connection = MyDatabaseUtils.getConnection();
			
			System.out.println("Connection done");
			
			// create a select statement to retrieve all the admin account on the users
//			String SELECT_SQL = "SELECT username FROM users WHERE username = '" + firstName + "'";
			String SELECT_SQL = "SELECT * FROM users";

			// Initialized a Statement object from Connection
			Statement statement = connection.createStatement();
			
			System.out.println("Statement created");
			
			// execute the query
			ResultSet resultSet = statement.executeQuery(SELECT_SQL);
			
			System.out.println("ResulSet created");

			
			// check for given user
			while (resultSet.next()) {
				if ((resultSet.getString("username").equals(firstName)) &&(resultSet.getString("password").equals(oldPassword))) {
					System.out.println("Admin found");
					id = resultSet.getInt("Id");
					System.out.println(id);
					break;
				}
			}

			if (id != 0) {
				
				Connection connection2 = MyDatabaseUtils.getConnection();
				
				String UPDATE_SQL = "UPDATE users SET password ='" + newPassword + "' WHERE Id= " + id;
							
				// create a PreparedStatement
				PreparedStatement preparedStatement = connection2.prepareStatement(UPDATE_SQL);

				// execute the PreparedStatement
				preparedStatement.executeUpdate();

				// closing resources
				preparedStatement.close();
				statement.close();
				connection.close();

				response.sendRedirect("homepage.jsp");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			e.getMessage().getClass();
		}
	}

}
