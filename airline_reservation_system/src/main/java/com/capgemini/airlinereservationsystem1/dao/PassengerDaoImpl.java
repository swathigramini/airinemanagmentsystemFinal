package com.capgemini.airlinereservationsystem1.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;
import com.capgemini.airlinereservationsystem1.db.Repository;

public class PassengerDaoImpl implements PassengerDao {
	Repository repository = new Repository();

	private HashMap<Integer, Passenger> passengerData = repository.passengerData;
	private HashMap<Integer, Flight> flightData = repository.flightData;
	private HashMap<Integer, Ticket> ticketData = repository.ticketData;

	public Passenger passengerLogin(int passengerId, String passengerPassword) {
		try {
			Iterator<Map.Entry<Integer, Passenger>> iterator = passengerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Passenger> entry = iterator.next();
				if (passengerId == (entry.getValue().getPassengerId())
						&& passengerPassword.equals(entry.getValue().getPassengerPassword())) {
					return entry.getValue();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of passengerLogin

	public boolean registerPassengerCheck(int passengerId) {
		try {
			Iterator<Map.Entry<Integer, Passenger>> iterator = passengerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Passenger> entry = iterator.next();
				if (passengerId == (entry.getValue().getPassengerId())) {
					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of addPassengerCheck

	public boolean registerPassenger(Passenger passenger) {

		try {

			Integer i = 0;
			Iterator<Map.Entry<Integer, Passenger>> iterator = passengerData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Passenger> entry = iterator.next();
				i = entry.getKey();
			}

			passengerData.put(i + 1, passenger);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}// end of addPassenger

	public List<Flight> viewFlight() {
		try {
			List<Flight> flight = new LinkedList<Flight>();
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Flight> entry = iterator.next();
				flight.add(entry.getValue());
			}
			return flight;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}// end of view flight

	public Ticket bookTicket(Ticket ticket) {
		try {
			Integer i = 0;
			Iterator<Map.Entry<Integer, Ticket>> iterator = ticketData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Ticket> entry = iterator.next();
				i = entry.getKey();
				return ticket;
			}

			ticketData.put(i + 1, ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

	public boolean TicketCancellation(int ticketId) {
		try {
			Iterator<Map.Entry<Integer, Ticket>> iterator = ticketData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Ticket> entry = iterator.next();

				if (ticketId == (entry.getValue().getTicketId())) {
					iterator.remove();
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}// end of deleteFlight

	@Override
	public Flight searchFlight(int flightId) {
		try {
			Flight flight = new Flight();
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Flight> entry = iterator.next();
				if (flight.getFlightId() == entry.getValue().getFlightId()) {
					entry.setValue(flight);
					return flight;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Flight flightAvailable(int flightId) {
		try {
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Flight> entry = iterator.next();
				if (flightId == (entry.getValue().getFlightId())) {
					return entry.getValue();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}// end of flight availability

	@Override
	public List<Ticket> viewTicketDetails() {
		try {
			List<Ticket> ticket = new LinkedList<Ticket>();
			Iterator<Map.Entry<Integer, Ticket>> iterator = ticketData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Ticket> entry = iterator.next();
				ticket.add(entry.getValue());
			}
			return ticket;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}