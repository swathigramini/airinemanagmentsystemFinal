package com.capgemini.airlinereservationsystem1.service;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;

public interface PassengerService {
	 
	List<Flight> viewFlight();

	Ticket bookTicket(Ticket ticket);

	public boolean TicketCancellation(int ticketId);

	Passenger passengerLogin(int passengerId, String passengerPassword);
	
	boolean registerPassengerCheck(int passengerId);

	boolean registerPassenger(Passenger passenger);
	
	public Flight searchFlight(int flightId);
		
	Flight flightAvailable(int flightId);
	
	List<Ticket> viewTicketDetails();
}
