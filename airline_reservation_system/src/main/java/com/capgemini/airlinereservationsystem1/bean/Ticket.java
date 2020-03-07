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
	private String journeyTime;
	public String getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + flightId;
		result = prime * result + ((journeyDate == null) ? 0 : journeyDate.hashCode());
		result = prime * result + noOfSeats;
		result = prime * result + passengerId;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ticketId;
		long temp;
		temp = Double.doubleToLongBits(ticketPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (bookingId != other.bookingId)
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightId != other.flightId)
			return false;
		if (journeyDate == null) {
			if (other.journeyDate != null)
				return false;
		} else if (!journeyDate.equals(other.journeyDate))
			return false;
		if (noOfSeats != other.noOfSeats)
			return false;
		if (passengerId != other.passengerId)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (ticketId != other.ticketId)
			return false;
		if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
			return false;
		return true;
	}
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
