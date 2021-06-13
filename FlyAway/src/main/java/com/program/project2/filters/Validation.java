package com.program.project2.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.program.project2.utils.MyDatabaseUtils;

/**
 * Servlet Filter implementation class Validation
 */
@WebFilter("/SelectionServlet")
public class Validation implements Filter {

    /**
     * Default constructor. 
     */
    public Validation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			// Establishing the connection
			Connection connection = MyDatabaseUtils.getConnection();
			
			// create a select statement to retrieve all the admin account on the users table
			String SELECT_SQL = "SELECT * FROM users";
			
			// Initialized a Statement object from Connection
			Statement statement = connection.createStatement();
			
			// execute the query
			ResultSet resultSet = statement.executeQuery(SELECT_SQL);
			
			// boolean variable
			boolean found = false;
			
			// check for given user
			while(resultSet.next()) {
				if((resultSet.getString("username").equals(request.getParameter("user")) && (resultSet.getString("password").equals(request.getParameter("pass"))))){
					found = true;
					break;
				}
			}
			
			if (found) {
				String name = request.getParameter("user");
				request.setAttribute("user", name);
				
				resultSet.close();
				statement.close();
				connection.close();
				
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}else {
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("homepage.jsp").include(request, response);
				out.println("<h3 style ='color:red' align='center'> Invalid username/password </h3>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}	

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
