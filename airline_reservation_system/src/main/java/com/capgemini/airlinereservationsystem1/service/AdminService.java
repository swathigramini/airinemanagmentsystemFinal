package com.capgemini.airlinereservationsystem1.service;

import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Admin;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;

public interface AdminService {
	public boolean adminLogin(int adminId, String adminPassword);

	public boolean addManager(Manager manager);

	public boolean addFlightCheck(int managerId);

	public boolean deleteManager(int managerId);

	public boolean updateFlightCheck(int managerId);

	public void updateManager(Manager manager);

	public List<Manager> viewManager();

	

}
