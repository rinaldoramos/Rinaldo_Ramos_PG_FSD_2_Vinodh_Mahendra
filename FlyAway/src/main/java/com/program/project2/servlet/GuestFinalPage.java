package com.program.project2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.program.project2.dto.FlightInformation;

/**
 * Servlet implementation class GuestFinalPage
 */
@WebServlet("/GuestFinalPage")
public class GuestFinalPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestFinalPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		FlightInformation flightInformation = (FlightInformation)session.getAttribute("flightInfo");
		
		out.println("<h1 align='center'>Congratulations for your booking</h1><br/><h2 align='center'>Please see below the information of your flight</h2><br/><br/><br/>");
		out.println("<h4 align='center'>" + request.getParameter("fname") + " " + request.getParameter("lname"));
		out.println("<table>");
		out.println("<tr>");
		if (flightInformation.getTime() == 1) {
			out.println("<td><p>Flight No: " + flightInformation.getFlightId() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + flightInformation.getSource() + " To: " + flightInformation.getDestination() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 8:00 AM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 12:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		}else if (flightInformation.getTime() == 2) {
			out.println("<td><p>Flight No: " + flightInformation.getFlightId() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + flightInformation.getSource() + " To: " + flightInformation.getDestination() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 10:00 AM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 2:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		}
		else if (flightInformation.getTime() == 3) {
			out.println("<td><p>Flight No: " + flightInformation.getFlightId() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + flightInformation.getSource() + " To: " + flightInformation.getDestination() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 1:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 5:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		}else {
			out.println("<td><p>Flight No: " + flightInformation.getFlightId() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + flightInformation.getSource() + " To: " + flightInformation.getDestination() + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 5:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 9:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		}
		out.println("</tr>");
		out.println("</table>");
		
	}

}
