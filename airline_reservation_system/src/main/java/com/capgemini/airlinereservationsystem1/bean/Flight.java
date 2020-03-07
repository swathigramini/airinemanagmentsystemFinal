package com.capgemini.airlinereservationsystem1.bean;

import java.util.Date;

public class Flight {
	
	private int flightId;
	private String flightName;
	private String destination;
	private String source;
	private String date;
	private int totalNoOfseats;
	private double ticketPrice;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + flightId;
		result = prime * result + ((flightName == null) ? 0 : flightName.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ticketPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + totalNoOfseats;
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
		Flight other = (Flight) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightId != other.flightId)
			return false;
		if (flightName == null) {
			if (other.flightName != null)
				return false;
		} else if (!flightName.equals(other.flightName))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
			return false;
		if (totalNoOfseats != other.totalNoOfseats)
			return false;
		return true;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
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
	public int getTotalNoOfseats() {
		return totalNoOfseats;
	}
	public void setTotalNoOfseats(int totalNoOfseats) {
		this.totalNoOfseats = totalNoOfseats;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", destination=" + destination + ", source="
				+ source + ", totalNoOfseats=" + totalNoOfseats + ", ticketPrice=" + ticketPrice + ",date="+date+"]";
	}


}
