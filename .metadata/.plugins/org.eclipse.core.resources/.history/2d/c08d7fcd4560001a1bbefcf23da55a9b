package com.capgemini.airlinereservationsystem1.bean;

public class Manager {
	private int managerId;
    private String managerName;
	private long managerContact;
	private String managerPassword;
	private String managerEmail;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (managerContact ^ (managerContact >>> 32));
		result = prime * result + ((managerEmail == null) ? 0 : managerEmail.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((managerPassword == null) ? 0 : managerPassword.hashCode());
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
		Manager other = (Manager) obj;
		if (managerContact != other.managerContact)
			return false;
		if (managerEmail == null) {
			if (other.managerEmail != null)
				return false;
		} else if (!managerEmail.equals(other.managerEmail))
			return false;
		if (managerId != other.managerId)
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (managerPassword == null) {
			if (other.managerPassword != null)
				return false;
		} else if (!managerPassword.equals(other.managerPassword))
			return false;
		return true;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public long getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(long managerContact) {
		this.managerContact = managerContact;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

}
