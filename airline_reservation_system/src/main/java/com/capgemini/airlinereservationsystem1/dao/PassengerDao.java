package com.capgemini.airlinereservationsystem1.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;

public interface PassengerDao {
	List<Flight> viewFlight();
	
	public Flight searchFlight(int flightId);

	Ticket bookTicket(Ticket ticket);

	public boolean TicketCancellation(int ticketId);

	Passenger passengerLogin(int passengerId, String passengerPassword);

	boolean registerPassengerCheck(int passengerId);

	boolean registerPassenger(Passenger passenger);
	
	Flight flightAvailable(int flightId);

	List<Ticket> viewTicketDetails();
}
