package com.capgemini.airlinereservationsystem1.bean;

public class Availability {
	private int availId;
	private String availDate;
	private int  availSeat;
	private int  flightId;
	
	public int getAvailId() {
		return availId;
	}
	public int setAvailId(int availId) {
		return this.availId=availId;
	}
	public String getAvailDate() {
		return availDate;
	}
	public void setAvailDate(String availDate) {
		this.availDate = availDate;
	}
	public int getAvailSeat() {
		return availSeat;
	}
	
	public void setAvailSeat(int availSeat) {
		this.availSeat = availSeat;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	@Override
	public String toString() {
		return "Availability [availId=" + availId + ", availDate=" + availDate + ", availSeat=" + availSeat
				+ ", flightId=" + flightId + "]";
	}

}
