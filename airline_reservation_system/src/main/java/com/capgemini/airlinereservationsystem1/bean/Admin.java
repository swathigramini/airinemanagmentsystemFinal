package com.capgemini.airlinereservationsystem1.bean;

public class Admin {
	private int adminId;
	private String adminPassword;
	private String adminName;
	private String adminEmail;
	private long adminMobile;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminEmail == null) ? 0 : adminEmail.hashCode());
		result = prime * result + adminId;
		result = prime * result + (int) (adminMobile ^ (adminMobile >>> 32));
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
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
		Admin other = (Admin) obj;
		if (adminEmail == null) {
			if (other.adminEmail != null)
				return false;
		} else if (!adminEmail.equals(other.adminEmail))
			return false;
		if (adminId != other.adminId)
			return false;
		if (adminMobile != other.adminMobile)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		return true;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public long getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(long mobile) {
		this.adminMobile = mobile;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminName=" + adminName
				+ ", adminEmail=" + adminEmail + ", adminMobile=" + adminMobile + "]";
	}
	

}
