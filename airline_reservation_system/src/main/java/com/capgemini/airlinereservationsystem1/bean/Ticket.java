package com.capgemini.airlinereservationsystem1.bean;

import java.util.Date;

public class Ticket {
	private int ticketId;
	private double ticketPrice;
	private int noOfSeats;
	private int flightId;
	private int passengerId;
	private String destination;
	private String source;
	private int bookingId;
	private String journeyDate;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookigId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getFlightId() {
		return flightId;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketPrice=" + ticketPrice + ", noOfSeats=" + noOfSeats
				+ ", flightId=" + flightId + ", passengerId=" + passengerId + ", destination=" + destination + ", source="
				+ source + ",journeyDate="+journeyDate+"]";
	}

}
