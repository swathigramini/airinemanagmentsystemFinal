package com.capgemini.airlinereservationsystem1.dao;

import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Admin;
import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;

public interface AdminDao {
	public boolean adminLogin(int adminId, String adminPassword);

	boolean addManager(Manager manager);

	boolean addFlightCheck(int managerId);

	boolean deleteManager(int managerId);

	boolean updateFlightCheck(int managerId);

	boolean updateManager(Manager manager);

	List<Manager> viewManager();

}
