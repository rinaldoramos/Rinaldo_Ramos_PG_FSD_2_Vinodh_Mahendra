package com.program.project2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import com.google.protobuf.TextFormat.ParseException;
import com.program.project2.dto.FlightInformation;

/**
 * Servlet implementation class GuestFlightOptionServlet
 */
@WebServlet("/GuestFlightOptionServlet")
public class GuestFlightOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestFlightOptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// create an array of set of numbers
		ArrayList<Integer> flightIdNumbers = new ArrayList<Integer>();
		int counter = 0; // to get another flight number
		for(int i = 100; i < 1000; i++) {
			flightIdNumbers.add(i);
		}
		
		// shuffling the numbers in the array
		Collections.shuffle(flightIdNumbers);		
		
		// create a flight object to add information from the guest and a Date object to get teh selected day for the flight
		FlightInformation flightInformation = new FlightInformation();
		Date date = null;
	
		try {		
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("trip-date"));					
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Exception from the Date try/catch");
		}
		
		// retrieving the other values
		String sCountry = request.getParameter("sourceCountry");
		String dCountry = request.getParameter("destinationCountry");
		int people = Integer.parseInt(request.getParameter("passangers"));
		
		// assigning the values to the flight attributes
		flightInformation.setDate(date);
		flightInformation.setSource(sCountry);
		flightInformation.setDestination(dCountry);
		flightInformation.setPeople(people);
		flightInformation.setPrice(0.0);
		
		// determine price based on USA to Dominican Republic or viceversa
		if ((sCountry.equals("USA") && dCountry.equals("Dominican Republic")) || (sCountry.equals("Dominican Republic") && dCountry.equals("USA"))) { // $500
			flightInformation.setPrice(500.00 * flightInformation.getPeople());
		}else if ((sCountry.equals("USA") && dCountry.equals("UK")) || (sCountry.equals("UK") && dCountry.equals("USA"))) { // $800
			flightInformation.setPrice(800.00 * flightInformation.getPeople());
		}else { // $1,000
			flightInformation.setPrice(1_000.00 * flightInformation.getPeople());
		}
		
		// display a table to the user with the available flights 
		PrintWriter out = response.getWriter();
		int flightIdNumber;
		int fId1 = 0;
		int fId2 = 0;
		int fId3 = 0;
		int fId4 = 0;
		
		response.setContentType("text/html");
		// creating the HttpSession
		HttpSession session = request.getSession();
		
		out.println("<h3>Please make a selection from the options shown below...</h3>");
		out.println("<br/>");
		
		out.println("<form action='/FlyAway/GuestCustomerServlet'>");
		
		out.println("<table border='4'>");
		out.println("<tbody>");
		
		flightIdNumber = flightIdNumbers.get(counter);
		counter++;
		
		out.println("<tr>");	
		out.println("<td><p> Flight No: " + flightIdNumber + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + sCountry + " To: " + dCountry + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 8:00 AM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 12:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" +(flightInformation.getPrice()) + "</p></td>");
		out.println("<td>&nbsp;<input type=\"radio\" name=\"radioNumber\" value='1' checked/></td>");
		out.println("</tr>");
		
		fId1 = flightIdNumber;
		
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		
		flightIdNumber = flightIdNumbers.get(counter);
		counter++;	
		
		out.println("<tr>");
		out.println("<td><p>Flight No: " + flightIdNumber + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + sCountry + " To: " + dCountry + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 10:00 AM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 2:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		out.println("<td>&nbsp;<input type=\"radio\" name=\"radioNumber\" value='2'/></td>");
		out.println("</tr>");
		
		fId2 = flightIdNumber;
		
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		
		flightIdNumber = flightIdNumbers.get(counter);
		counter++;		
		
		out.println("<tr>");
		out.println("<td><p>Flight No: " + flightIdNumber + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + sCountry + " To: " + dCountry + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 1:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 5:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		out.println("<td>&nbsp;<input type=\"radio\" name=\"radioNumber\" value='3'/></td>");
		out.println("</tr>");
		
		fId3 = flightIdNumber;
		
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		
		flightIdNumber = flightIdNumbers.get(counter);
		counter++;		
		
		out.println("<tr>");
		out.println("<td><p>Flight No: " + flightIdNumber + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: " + sCountry + " To: " + dCountry + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Departing time: 5:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -Arriving time: 9:00 PM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -The price: $" + (flightInformation.getPrice()) + "</p></td>");
		out.println("<td>&nbsp;<input type=\"radio\" name=\"radioNumber\" value='4'/></td>");
		out.println("</tr>");
		out.println("</tbody>");
		
		fId4 = flightIdNumber;
				
		out.println("</table>");
		out.println("<br/><br/>");
		
		
		session.setAttribute("flightInfo", flightInformation);
		session.setAttribute("flightNo1", fId1);
		session.setAttribute("flightNo2", fId2);
		session.setAttribute("flightNo3", fId3);
		session.setAttribute("flightNo4", fId4);
		
		out.println("<input type='submit' style='width:20%' style='height:20%' value='Send'>");
		out.println("</form>");
	}
}























