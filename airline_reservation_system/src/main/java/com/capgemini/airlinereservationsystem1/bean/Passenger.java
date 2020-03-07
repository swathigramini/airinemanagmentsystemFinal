package com.capgemini.airlinereservationsystem1.bean;

public class Passenger {
	private int passengerId;
	private String passengerName;
	private String passengerEmail;
	private String passengerPassword;
	private long passengerContact;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (passengerContact ^ (passengerContact >>> 32));
		result = prime * result + ((passengerEmail == null) ? 0 : passengerEmail.hashCode());
		result = prime * result + passengerId;
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((passengerPassword == null) ? 0 : passengerPassword.hashCode());
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
		Passenger other = (Passenger) obj;
		if (passengerContact != other.passengerContact)
			return false;
		if (passengerEmail == null) {
			if (other.passengerEmail != null)
				return false;
		} else if (!passengerEmail.equals(other.passengerEmail))
			return false;
		if (passengerId != other.passengerId)
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerPassword == null) {
			if (other.passengerPassword != null)
				return false;
		} else if (!passengerPassword.equals(other.passengerPassword))
			return false;
		return true;
	}
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
