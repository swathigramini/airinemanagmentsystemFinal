package com.capgemini.airlinereservationsystem1.service;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.dao.ManagerDao;
import com.capgemini.airlinereservationsystem1.dao.ManagerDaoImpl;

public class ManagerServiceImpl implements ManagerService {
	
	ManagerDao managerDao=new ManagerDaoImpl();

	public boolean managerLogin(int managerId, String managerPassword) {
		return managerDao.managerLogin(managerId, managerPassword);
	}

	public boolean addFlightCheck(int flightId) {
		return managerDao.addFlightCheck(flightId);
	}

	public boolean addFlight(Flight flight) {
		return managerDao.addFlight(flight);
	}

	public boolean updateFlightCheck(int flightId) {
		return managerDao.updateFlightCheck(flightId);
	}

	public void updateFlight(Flight flight) {
		return;
	}
	
    public List<Flight> viewFlight() {
		return managerDao.viewFlight();
	}

	public List<Passenger> viewPassenger() {
		return managerDao.viewPassenger();
	}


	@Override
	public boolean FlightCancellation(int flightIdCancel) {
		return managerDao.FlightCancellation(flightIdCancel);
	}

}
