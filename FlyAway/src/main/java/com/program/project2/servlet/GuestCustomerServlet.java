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
 * Servlet implementation class GuestCustomerServlet
 */
@WebServlet("/GuestCustomerServlet")
public class GuestCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestCustomerServlet() {
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
		  int radioValue = Integer.parseInt(request.getParameter("radioNumber"));
		  
		  if (radioValue == 1) { flightInformation.setTime(radioValue);
		  flightInformation.setFlightId(session.getAttribute("flightNo1").toString());
		  }else if (radioValue == 2) { flightInformation.setTime(radioValue);
		  flightInformation.setFlightId(session.getAttribute("flightNo2").toString());
		  }else if (radioValue == 3) { flightInformation.setTime(radioValue);
		  flightInformation.setFlightId(session.getAttribute("flightNo3").toString());
		  }else { flightInformation.setTime(radioValue);
		  flightInformation.setFlightId(session.getAttribute("flightNo4").toString());
		  }
		 	
		
		out.println("<h3> Please fill out your information:</h3>");
		out.println("<form action='/FlyAway/GuestFinalPage'>");
		out.println("Enter Fistname:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='fname'>");
		out.println("&nbsp;&nbsp;&nbspEnter Lastname:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='lname'><br/><br/>");
		out.println("Enter Passport:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='passport'>");
		out.println("&nbsp;&nbsp;&nbsp&nbspEnter Address:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='address'><br/><br/>");
		out.println("Enter City:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='city'>");
		out.println("&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp&nbsp;&nbsp;&nbsp&nbspEnter State:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='state'><br/><br/>");
		out.println("ZipCode:	" + "&nbsp;&nbsp;&nbsp;<input type='text' name='zip'>");
		
		
		// For this exercise any value enter will work as a payment
		out.println("<h3> Please type payment information:</h3>");
		out.println("Credit card number:&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp&nbsp;&nbsp;&nbsp&nbsp <input type='text'><br/><br/>");
		out.println("Expiration Date:&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp&nbsp;&nbsp;&nbsp&nbsp M.<input type='text' size='2'>&nbsp;&nbsp&nbsp Y.<input type='text' size='2'><br/><br/>");
		out.println("CVV: <input type='text' size='2'><br/><br/>");
		out.println("Name on the Card:&nbsp;&nbsp&nbsp <input type='text'><br/><br/>");
		
		session.setAttribute("flightInfo", flightInformation);
		
		out.println("<input type='submit' style='width:5%' value='Send'><input type='reset' style='width:5%' value='Clear'>");
		out.println("</form>");
//		System.out.println(request.getParameter("radioNumber"));
//		System.out.println(session.getAttribute("flightNo1"));
//		System.out.println(session.getAttribute("flightNo2"));
//		System.out.println(session.getAttribute("flightNo3"));
//		System.out.println(session.getAttribute("flightNo4"));
	
	}

}
