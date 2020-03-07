package com.capgemini.airlinereservationsystem1.db;

import java.util.HashMap;
import java.util.HashSet;

import com.capgemini.airlinereservationsystem1.bean.Admin;
import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;

public class Repository {
	public static final HashMap< Integer,Admin> adminData = new HashMap<Integer, Admin>();
	public static final HashMap<Integer, Flight> flightData = new HashMap<Integer, Flight>();
	public static final HashMap<Integer, Passenger> passengerData = new HashMap<Integer, Passenger>();
	public static final HashMap<Integer, Manager> managerData = new HashMap<Integer, Manager>();
	public static final HashMap<Integer, Ticket> ticketData = new HashMap<Integer, Ticket>();
	public static final HashMap<Integer, Availability> availabilityData = new HashMap<Integer, Availability>();
	

	static{
		Admin admin1 = new Admin();
		admin1.setAdminId(101);
		admin1.setAdminPassword("qwerty@1Q");
		admin1.setAdminMobile(9550342181l);
		admin1.setAdminEmail("admin@gmail.com");
		admin1.setAdminName("Likitha");
		adminData.put(11,admin1);

		Manager manager = new Manager();
		manager.setManagerId(102);
		manager.setManagerPassword("qwerty@1Q");
		manager.setManagerContact(8639077011l);
		manager.setManagerEmail("malyavijay@gmail.com");
		manager.setManagerName("Vijaya Malya");
		managerData.put(11, manager);

		Flight flight = new Flight();
		flight.setFlightId(103);
		flight.setFlightName("Deccan");
		flight.setDestination("Bangalore");
		flight.setTicketPrice(900);
		flight.setSource("Hyderabad");
		flight.setDate("03-04-2020");
		flight.setTotalNoOfseats(150);

		Flight flight1 = new Flight();
		flight1.setFlightId(104);
		flight1.setFlightName("Kingfisher");
		flight1.setDestination("Bangalore");
		flight1.setTicketPrice(1300);
		flight1.setSource("Goa");
		flight1.setDate("10-03-1997");
		flight1.setTotalNoOfseats(200);

		flightData.put(1, flight);
		flightData.put(2, flight1);

		Passenger passenger = new Passenger();
		passenger.setPassengerId(105);
		passenger.setPassengerContact(9573241379l);
		passenger.setPassengerEmail("puna@gmail.com");
		passenger.setPassengerName("Punarha");
		passenger.setPassengerPassword("qwerty@1Q");

		Passenger passenger1 = new Passenger();
		passenger1.setPassengerId(106);
		passenger1.setPassengerContact(7799483088l);
		passenger1.setPassengerEmail("manvi@gmail.com");
		passenger1.setPassengerName("Manvi");
		passenger1.setPassengerPassword("qwerty@1Q");

		passengerData.put(1, passenger);
		passengerData.put(2, passenger1);

		Ticket ticket1 = new Ticket();
		ticket1.setFlightId(103);
		ticket1.setDestination("Hyderabad");
		ticket1.setSource("Bangalore");
		ticket1.setNoOfSeats(1);
		ticket1.setPassengerId(106);
		ticket1.setTicketPrice(100);
		//ticket1.setJourneyDate("2020-03-10");
		ticket1.setTicketId(1);
		ticketData.put(1, ticket1);

	     Availability availability = new Availability();
		availability.setFlightId(103);
		availability.setAvailId(103);
		availability.setAvailSeat(2);
		availability.setAvailDate("20-10-2020");

	}

}
