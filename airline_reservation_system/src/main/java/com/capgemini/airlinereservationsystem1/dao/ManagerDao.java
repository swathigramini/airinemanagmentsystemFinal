package com.capgemini.airlinereservationsystem1.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;

public interface ManagerDao {
	boolean managerLogin(int managerId, String managerPassword);

	List<Passenger> viewPassenger();

	boolean addFlightCheck(int flightId);

	boolean addFlight(Flight flight);

	boolean updateFlightCheck(int flightId);

	void updateFlight(Flight flight);

	List<Flight> viewFlight();
	 
	public boolean FlightCancellation(int flightIdCancel);

    
}
