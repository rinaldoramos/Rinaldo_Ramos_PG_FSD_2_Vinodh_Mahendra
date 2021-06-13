package com.program.project2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectionServlet
 */
@WebServlet("/SelectionServlet")
public class SelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h1> Hello " + request.getParameter("user") + "</h1><br/><br/>");
		out.println("<h2>What would you like to do...</h2><br/>");
		
		// create another session
		HttpSession session = request.getSession();
		session.setAttribute("user", request.getParameter("user"));
		out.println("<a href=change-password-form.html><input type='button' value='Change password'/></a>&nbsp;&nbsp;<a href='guest-selection.html'><input type='button' value='Continue'/></a>");
		
	}

}
