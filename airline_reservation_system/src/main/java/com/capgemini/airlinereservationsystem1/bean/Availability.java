package com.capgemini.airlinereservationsystem1.bean;

public class Availability {
	private int availId;
	private String availDate;
	private int  availSeat;
	private int  flightId;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availDate == null) ? 0 : availDate.hashCode());
		result = prime * result + availId;
		result = prime * result + availSeat;
		result = prime * result + flightId;
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
		Availability other = (Availability) obj;
		if (availDate == null) {
			if (other.availDate != null)
				return false;
		} else if (!availDate.equals(other.availDate))
			return false;
		if (availId != other.availId)
			return false;
		if (availSeat != other.availSeat)
			return false;
		if (flightId != other.flightId)
			return false;
		return true;
	}
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
