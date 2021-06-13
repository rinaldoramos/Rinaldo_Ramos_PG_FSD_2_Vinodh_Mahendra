package com.program.project2.dto;

import java.util.Date;

public class FlightInformation {

	private String flightId;
	private String source;
	private String destination;
	private int people;
	private Date date;
	private double price;
	private int time;
	
	public FlightInformation() {
		
	}	

	@Override
	public String toString() {
		return "FlightInformation [flightId=" + flightId + ", source=" + source + ", destination=" + destination
				+ ", people=" + people + ", date=" + date + ", price=" + price + ", time=" + time + "]";
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
