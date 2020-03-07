package com.capgemini.airlinereservationsystem1.service;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;
import com.capgemini.airlinereservationsystem1.dao.PassengerDao;
import com.capgemini.airlinereservationsystem1.dao.PassengerDaoImpl;

public class PassengerServiceImpl implements PassengerService {

	PassengerDao passengerDao = new PassengerDaoImpl();

	@Override
	public List<Flight> viewFlight() {
		return passengerDao.viewFlight();
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		return passengerDao.bookTicket(ticket);
	}


	@Override
	public Passenger passengerLogin(int passengerId, String passengerPassword) {
		return passengerDao.passengerLogin(passengerId, passengerPassword);
	}

	@Override
	public boolean registerPassengerCheck(int passengerId) {
		return passengerDao.registerPassengerCheck(passengerId);
	}

	@Override
	public boolean registerPassenger(Passenger passenger) {
		return passengerDao.registerPassenger(passenger);
	}

	@Override
	public Flight searchFlight(int flightId) {
		return passengerDao.searchFlight(flightId);
	} 

	@Override
	public Flight flightAvailable(int flightId) {
		return passengerDao.flightAvailable(flightId);
	}

	@Override
	public boolean TicketCancellation(int ticketId) {
		return passengerDao.TicketCancellation(ticketId);
	}

	@Override
	public List<Ticket> viewTicketDetails() {
		return passengerDao.viewTicketDetails();
	}

	
}