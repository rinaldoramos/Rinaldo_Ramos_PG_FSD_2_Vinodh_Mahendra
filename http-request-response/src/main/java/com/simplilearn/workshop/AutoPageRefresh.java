package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoPageRefresh
 */
@WebServlet("/auto-page-refresh")
public class AutoPageRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.setIntHeader("refresh", 3);
		
		Date currentData = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E DD-MM-YYYY  'at' HH:MM:SS   a");
		String currentDataAndTime = ft.format(currentData);
		
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Auto Page Refresh using HTTP Response Header </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p> Page Last Refreshed at : " + currentDataAndTime + "</p>");
		out.println("</body>");
		out.println("</html>");

	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
