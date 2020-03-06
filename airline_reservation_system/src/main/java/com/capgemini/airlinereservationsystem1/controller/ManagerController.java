package com.capgemini.airlinereservationsystem1.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.exception.AddFlightException;
import com.capgemini.airlinereservationsystem1.exception.AdminException;
import com.capgemini.airlinereservationsystem1.exception.ManagerException;
import com.capgemini.airlinereservationsystem1.service.ManagerService;
import com.capgemini.airlinereservationsystem1.service.ManagerServiceImpl;
import com.capgemini.airlinereservationsystem1.service.PassengerService;
import com.capgemini.airlinereservationsystem1.service.PassengerServiceImpl;
import com.capgemini.airlinereservationsystem1.validation.Validator;

public class ManagerController {
	static Scanner scanner = new Scanner(System.in);
	static ManagerService serviceManager = new ManagerServiceImpl();
	static PassengerService servicePassenger = new PassengerServiceImpl();
	static Validator validator = new Validator();
	static Flight flight = new Flight();
	static Passenger passenger = new Passenger();
	static Manager manager = new Manager();

	public static Manager managerLogin() throws ManagerException {
		int managerId = 0;
		try {

			while (true) {
				System.out.println("Enter manager id");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					managerId = sId;
					break;
				} else {
					System.out.println("Id should be Integer");
				}
			}
			System.out.println("Enter manager password");
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
			manager.setManagerPassword(password);

			boolean managerLogin = serviceManager.managerLogin(managerId, password);
			if (managerLogin) {
				System.out.println("Login successfully");
				getManagerFunction();
			} else {
				throw new ManagerException("Invalid username and password for admin");
			}
		} catch (ManagerException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}// end of ManagerLogin()

	private static void getManagerFunction() {

		System.out.println("select a option");
		System.out.println("1. Add flight");
		System.out.println("2. Update flight");
		System.out.println("3. Display all flight details");
		System.out.println("4. Cancel flight");
		System.out.println("5. Display all passenger details");
		System.out.println("6. Logout");
		int managerChoice = AirlineReservationSystemController.numValidate(scanner.next());

		switch (managerChoice) {

		case 1:

			addFlight();
			break;

		case 2:

			updateFlight();
			break;
		case 3:

			viewFlight();
			break;
		case 4:

			cancelFlight();
			break;

		case 5:
			viewPassenger();
			break;

		case 6:
			String a[] = new String[] { "1" };
			AirlineReservationSystemController.main(a);
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}// end of switch case
	}

	static void addFlight() {
		int flightId = 0;
		try {

			while (true) {

				System.out.println("Enter flight id");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					flightId = sId;
					flight.setFlightId(flightId);
					break;
				} else {
					System.out.println("Id should be Integer");
				}
			}

			boolean addFlightCheck = serviceManager.addFlightCheck(flightId);
			if (addFlightCheck) {
				System.out.println("this flight id is used by some other flight give another id");

				while (true) {
					System.out.println("Enter another flight id");
					Integer sId = validator.validateId(scanner.next());
					if (sId != null) {
						flightId = sId;
						flight.setFlightId(flightId);
						break;
					} else {
						System.out.println("Id should be Integer");
					}
				}

			}

			System.out.println("Enter flight name");
			flight.setFlightName(scanner.next());

			System.out.println("Enter destination");
			flight.setDestination(scanner.next());

			System.out.println("Enter source");
			flight.setSource(scanner.next());
			System.out.println("Enter price");
			flight.setTicketPrice(scanner.nextDouble());

			System.out.println("Enter total number of seats");
			flight.setTotalNoOfseats(scanner.nextInt());

			// flight.setFlightId(flightId);
			/*
			 * flight.setFlightName(flightName); flight.setSource(source);
			 * flight.setDestination(destination); flight.setTicketPrice(ticketPrice);
			 * flight.setTotalNoOfseats(totalNoOfSeats);
			 */

			boolean addFlight = serviceManager.addFlight(flight);
			if (addFlight) {
				System.out.println(" passenger record inserted");
				System.out.println("press 0 to go back");
				int option = scanner.nextInt();
				if (option == 0) {
					getManagerFunction();
				}
			} else {
				throw new AddFlightException("Record is already present");
			}

		} catch (AddFlightException e) {
			e.printStackTrace();
		}

	}// end of addFlight

	static void updateFlight() {

		try (Scanner scanner = new Scanner(System.in)) {

			int flightId = 0;
			while (true) {
				System.out.println("Enter flight id that you want to update");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					flightId = sId;
					break;
				} else {
					System.out.println("Id should be Integer");
				}
			}

			boolean updateFlightCheck = serviceManager.updateFlightCheck(flightId);
			if (updateFlightCheck) {

				System.out.println("Enter flight name");
				String flightName = scanner.next();
				flight.setFlightName(flightName);

				System.out.println("Enter source");
				String source = scanner.next();
				flight.setSource(source);

				System.out.println("Enter destination");
				String destination = scanner.next();
				flight.setDestination(destination);

				System.out.println("Enter price");
				double ticketPrice = scanner.nextDouble();
				flight.setTicketPrice(ticketPrice);

				System.out.println("Enter total number of seats");
				int totalNoOfSeats = scanner.nextInt();
				flight.setTotalNoOfseats(totalNoOfSeats);

				serviceManager.updateFlight(flight);

				System.out.println("record updated");
				System.out.println("press 0 to go back");
				int option = scanner.nextInt();
				if (option == 0) {
					getManagerFunction();
				}

			} else {
				System.out.println("Flight id is not present");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of updateFlight

	static void viewFlight() {
		List<Flight> flightData = new LinkedList<>();
		flightData = serviceManager.viewFlight();
		if (flightData == null) {
			System.out.println("No records present");

		} else {
			for (Flight flight : flightData) {
				System.out.println("flight id= " + flight.getFlightId());
				System.out.println("flight name= " + flight.getFlightName());
				System.out.println("source= " + flight.getSource());
				System.out.println("destination= " + flight.getDestination());
				System.out.println("Total no of seats= " + flight.getTotalNoOfseats());
				System.out.println("Ticket Price= " + flight.getTicketPrice());
				System.out.println("----------------------------------------------------");
			}
			System.out.println("press 0 to go back");
			int option = scanner.nextInt();
			if (option == 0) {
				getManagerFunction();
			}
		}
	}// end of view flight

     public static void cancelFlight() {
		try {
			int flightId = 0;
			while (true) {
				System.out.println("Enter flight id you want to cancel");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					flightId = sId;
					break;
				} else {
					System.out.println("Id should be only an Integer");
				}
			}
			boolean flightCancel = serviceManager.FlightCancellation(flightId);
			if (flightCancel) {
				System.out.println("Flight Cancelled SuccessFully!!!!");
				System.out.println("press 0 to go back");
				int option = scanner.nextInt();
				if (option == 0) {
					getManagerFunction();
				}

			} else {
				throw new ManagerException("Record  not present");
			}

		} catch (ManagerException e) {
			e.printStackTrace();
		}

	}// end of cancelFlight

	public static List<Passenger> viewPassenger() {
		List<Passenger> passengerData = new LinkedList<>();
		passengerData = serviceManager.viewPassenger();
		if (passengerData == null) {
			System.out.println("No records present");
		} else {
			for (Passenger passenger : passengerData) {
				System.out.println("passenger id= " + passenger.getPassengerId());
				System.out.println("passenger name= " + passenger.getPassengerName());
				System.out.println("passenger contact =" + passenger.getpassengerContact());
				System.out.println("------------------------------------------------");
			}
			System.out.println("press 0 to go back");
			int option = scanner.nextInt();
			if (option == 0) {
				getManagerFunction();
			}
		}
		return passengerData;
	}// end of view all passenger
}