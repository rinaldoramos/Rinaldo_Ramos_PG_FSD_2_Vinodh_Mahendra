package com.program.project2.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.program.project2.utils.MyDatabaseUtils;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("newName");
		String nPassword = request.getParameter("newPassword");
		
		try {
			
			//Initialize the database
			Connection connection = MyDatabaseUtils.getConnection();
			
			String INSERT_SQL = "insert into users (username,password) values(?,?)";
			
			// create a Prepared Statement
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
			
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, nPassword);			
			
			preparedStatement.executeUpdate();
			
			// closing resources
			preparedStatement.close();			
			connection.close();

			response.sendRedirect("homepage.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}
	}

}
