package com.capgemini.airlinereservationsystem1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;
import com.capgemini.airlinereservationsystem1.exception.AdminException;
import com.capgemini.airlinereservationsystem1.exception.PassengerException;
import com.capgemini.airlinereservationsystem1.exception.TicketException;
import com.capgemini.airlinereservationsystem1.service.ManagerService;
import com.capgemini.airlinereservationsystem1.service.ManagerServiceImpl;
import com.capgemini.airlinereservationsystem1.service.PassengerService;
import com.capgemini.airlinereservationsystem1.service.PassengerServiceImpl;
import com.capgemini.airlinereservationsystem1.validation.Validator;

public class PassengerController {
	static Validator validator = new Validator();
	static PassengerService servicePassenger = new PassengerServiceImpl();
	static ManagerService serviceManager = new ManagerServiceImpl();
	static Scanner scanner = new Scanner(System.in);
	static Passenger passenger = new Passenger();
	static int passengerId;

	static Passenger passengerLogin() throws PassengerException {
		int passengerId = 0;
		try {
			System.out.println("Enter passenger id");
			while (true) {
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					passengerId = sId;
					passenger.setPassengerId(passengerId);
					break;
				} else {
					System.out.println("Id should be Integer");
				}
			}

			System.out.println("Enter passenger password");
			String password = null;
			char c1 = 'y';
			while (c1 == 'y') {
				password = scanner.next();
				if (Validator.isPassword(password)) {
					c1 = 'n';
				} else {
					System.err.println("enter correct password pattern");
				}
			}

			passenger.setPassengerPassword(password);

			Passenger passengerLogin = new Passenger();
			passengerLogin = servicePassenger.passengerLogin(passengerId, password);
			if (passengerLogin != null) {
				System.out.println("Login successfully");
				getPassengerFunction();
			} else {
				throw new PassengerException("Invalid username and password for passenger");

			}
		} catch (PassengerException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}// end of passenger login

	private static void getPassengerFunction() {
		System.out.println("select a option");
		System.out.println("1. Register Passenger");
		System.out.println("2. View flight details");
		System.out.println("3. Book ticket");
		System.out.println("4. Cancel ticket");
		System.out.println("5. Logout");
		int passengerChoice = AirlineReservationSystemController.numValidate(scanner.next());
		// Flight flightId = new Flight();
		Passenger passengerLogin = new Passenger();

		switch (passengerChoice) {
		case 1:
			registerPassenger();
			break;
		case 2:
			viewFlight();
			break;

		case 3:
			bookTicket(passengerLogin);
			break;

		case 4:
			cancelTicket();
			break;
		case 5:
			String a[] = new String[] { "1" };
			AirlineReservationSystemController.main(a);
			break;

		default:
			System.out.println("Invalid choice made");
			break;
		}// end of switch case
	}

	public static void registerPassenger() {
		try {
			System.out.println("Enter passenger id");
			while (true) {
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					passengerId = sId;
					passenger.setPassengerId(passengerId);
					break;
				} else {
					System.out.println("Id should be Integer");
				}
			}
			boolean addPassengerCheck = servicePassenger.registerPassengerCheck(passengerId);
			if (addPassengerCheck) {
				System.out.println("this passenger id is used by someother passenger give another one");
				System.out.println("Enter another passenger id");
				passengerId = scanner.nextInt();
			}

			System.out.println("Enter passenger name");
			String name = null;
			char ch1 = 'y';
			while (ch1 == 'y') {
				name = scanner.next();
				if (Validator.isName(name)) {
					ch1 = 'n';
				} else {
					System.err.println("invalid credentials");
				}
			}
			passenger.setPassengerName(name);
			System.out.println("Enter passenger password");
			String password = null;
			char c1 = 'y';
			while (c1 == 'y') {
				password = scanner.next();
				if (Validator.isPassword(password)) {
					c1 = 'n';
				} else {
					System.err.println("enter correct password pattern");
				}
			}
			passenger.setPassengerPassword(password);
			System.out.println("Enter passenger contact number");
			passenger.setPassengerContact(scanner.nextLong());
			System.out.println("Enter manager emailId");
			String email = null;
			char ch = 'y';
			while (ch == 'y') {
				email = scanner.next();
				if (Validator.isEmail(email)) {
					ch = 'n';
				} else {
					System.err.println("enter correct email pattern");
				}
			}
			passenger.setPassengerEmail(email);

			boolean addPassenger = servicePassenger.registerPassenger(passenger);
			if (addPassenger) {
				System.out.println(" passenger record inserted");
				System.out.println("press 0 to go back");
				int option = scanner.nextInt();
				if (option == 0) {
					getPassengerFunction();
				}
			} else {
				throw new AdminException("Record is already present");
			}

		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}// end of add passenger

	static void viewFlight() {
		List<Flight> flightData = new LinkedList<>();
		flightData = servicePassenger.viewFlight();
		if (flightData == null) {
			System.out.println("No records present");
		} else {
			for (Flight flight : flightData) {
				System.out.println("flight id= " + flight.getFlightId());
				System.out.println("flight name= " + flight.getFlightName());
				System.out.println("destination= " + flight.getDestination());
				System.out.println("source= " + flight.getSource());
				System.out.println("Total no of seats= " + flight.getTotalNoOfseats());
				System.out.println("Ticket Price= " + flight.getTicketPrice());
				System.out.println("Journey date=" + flight.getDate());
				System.out.println("------------------------------------------------");
			}
			System.out.println("press 0 to exit");
			int option = scanner.nextInt();
			if (option == 0) {
				getPassengerFunction();

			}
		}
	}// end of view flight

	static void bookTicket(Passenger passengerLogin) {

		Random random = new Random();
		Ticket ticket = new Ticket();
		System.out.println(" Enter flight id you want to book ticket");
		try {
			int bookFlightId = scanner.nextInt();

			Flight bookFlight = servicePassenger.flightAvailable(bookFlightId);
			if (bookFlight != null) {
				int ticketId = random.nextInt(50);
				int flightId = bookFlight.getFlightId();
				System.out.println("Flight Id is :" + flightId);
				String source = bookFlight.getSource();
				System.out.println("Source :" + source);
				String destination = bookFlight.getDestination();
				System.out.println("Destination :" + destination);
				/* String journeyDate=bookFlight.getDate(); */
				System.out.println("*********************************");

				System.out.println("Enter passenger id:");
				int id = scanner.nextInt();
				System.out.println("Enter no of seats you want");
				int seats = scanner.nextInt();
				// double price=(bookFlight.getTicketPrice()*seats);
				System.out.println("Enter flightId:");
				while (true) {
					Integer sId = validator.validateId(scanner.next());
					if (sId != null) {
						flightId = sId;
						break;
					} else {
						System.out.println("Id should be Integer");
					}
				}

				System.out.println("Enter ticket price:");
				double ticketprice = scanner.nextDouble();
				System.out.println("Enter booking id:");
				int bookId = scanner.nextInt();
				
				System.out.println("Enter date:");
				String journeyDate = null;
				char ch = 'y';
				while (ch == 'y') {
					journeyDate = scanner.next();
					if (Validator.dateValidation(journeyDate)) {
						ch = 'n';
						passenger.setPassengerEmail(journeyDate);
					} else {
						System.err.println("enter correct date");
					}
				}
				servicePassenger.bookTicket(ticket);
				System.out.println("ticket booked");

			} else {
				throw new TicketException("Flight is not available");
			}
		} catch (TicketException e) {
			System.out.println(e.getMessage());
		}

	}// end of book ticket

	static void cancelTicket() {
		System.out.println("Enter ticket id which you have to cancel");
		try {
			int ticketId = scanner.nextInt();
			boolean ticketExist = servicePassenger.cancelTicket(ticketId);
			if (ticketExist) {
				System.out.println("Ticket is cancelled");
				System.out.println("press 0 to exit");
				int option = scanner.nextInt();
				if (option == 0) {
					getPassengerFunction();
				}
			} else {
				throw new PassengerException("Ticket id is not available for the passenger");
			}
		} catch (PassengerException e) {
			System.out.println(e.getMessage());
		}
	}

}// end of cancelTicket