package com.capgemini.airlinereservationsystem1.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.db.Repository;
import com.capgemini.airlinereservationsystem1.exception.ManagerException;

public class ManagerDaoImpl implements ManagerDao {
	Repository repository = new Repository();

	private HashMap<Integer, Manager> managerData = repository.managerData;
	private HashMap<Integer, Flight> flightData = repository.flightData;
	private HashMap<Integer, Availability> availabilityData = repository.availabilityData;
	private HashMap<Integer, Passenger> passengerData = repository.passengerData;

	public boolean managerLogin(int managerId, String managerPassword) {
		try {
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Manager> entry = iterator.next();
				if (managerId == (entry.getValue().getManagerId())
						&& managerPassword.equals(entry.getValue().getManagerPassword())) {
					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of managerLogin

	public boolean addFlightCheck(int flightId) {
		try {
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Flight> entry = iterator.next();
				if (flightId == entry.getValue().getFlightId()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of addFlight

	public boolean addFlight(Flight flight) {
		try {
			Integer i = 0;
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Flight> entry = iterator.next();
				i = entry.getKey();
			}
			flightData.put(i + 1, flight);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}// end of addFlight

	public boolean updateFlightCheck(int flightId) {
		try {
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Flight> entry = iterator.next();
				if (flightId == (entry.getValue().getFlightId())) {
					return true;
				}
			}
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		return false;
	}// end of updateFlightCheck

	public void updateFlight(Flight flight) {
		try {
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Flight> entry = iterator.next();
				if (flight.getFlightId() == (entry.getValue().getFlightId())) {
					entry.setValue(flight);
				}else {
					throw new ManagerException("Flight id does not Exist");
				}
			}
		} catch (ManagerException e) {
			System.out.println(e.getMessage());
		}
		return;

	}// end of updateFlight

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
	}// end of viewFlight

	public List<Passenger> viewPassenger() {
		try {

			List<Passenger> passenger = new LinkedList<Passenger>();
			Iterator<Map.Entry<Integer, Passenger>> iterator = passengerData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Passenger> entry = iterator.next();
				passenger.add(entry.getValue());
			}

			return passenger;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of view Passenger

	public boolean FlightCancellation(int flightIdCancel) {
		try {
			Iterator<Map.Entry<Integer, Flight>> iterator = flightData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Flight> entry = iterator.next();

				if (flightIdCancel == (entry.getValue().getFlightId())) {
					iterator.remove();
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}// end of deleteFlight
}
