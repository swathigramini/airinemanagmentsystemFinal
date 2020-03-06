package com.capgemini.airlinereservationsystem1.bean;

public class Passenger {
	private int passengerId;
	private String passengerName;
	private String passengerEmail;
	private String passengerPassword;
	private long passengerContact;
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerPassword() {
		return passengerPassword;
	}
	public void setPassengerPassword(String passengerPassword) {
		this.passengerPassword = passengerPassword;
	}
	public long getpassengerContact() {
		return passengerContact;
	}
	public void setPassengerContact(long passengerContact) {
		this.passengerContact = passengerContact;
	}
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerEmail="
				+ passengerEmail + ", passengerPassword=" + passengerPassword + ", passengerContact=" + passengerContact
				+ "]";
	}
	
	

}
