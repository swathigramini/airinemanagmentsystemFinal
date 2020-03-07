package com.capgemini.airlinereservationsystem1.dao;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.exception.AddFlightException;
import com.capgemini.airlinereservationsystem1.exception.ManagerException;

public class ManagerDaoImplTest extends TestCase {
	private Flight flightInfo = new Flight();
	private ManagerDao admi = new ManagerDaoImpl();

	@Test
	void addFlightCheckTest() {
		flightInfo = new Flight();
		flightInfo.setFlightId(113);
		flightInfo.setFlightName("indigo");
		flightInfo.setSource("bengaluru");
		flightInfo.setDestination("delhi");
		flightInfo.setTotalNoOfseats(12);
		flightInfo.setDate("12-11-2020");
		flightInfo.setTicketPrice(1233.8);
		try {
			boolean expectedFlag = admi.addFlightCheck(113);
			assertEquals(expectedFlag, false);
		} catch (Exception e) {
			assertThrows(AddFlightException.class, () -> {
				admi.addFlightCheck(113);
			});
		}
		
	}
	@Test
	void addFlightTest() {
		flightInfo = new Flight();
		flightInfo.setFlightId(113);
		flightInfo.setFlightName("indigoMarine");
		flightInfo.setSource("mangaluru");
		flightInfo.setDestination("dehradun");
		flightInfo.setTotalNoOfseats(14);
		flightInfo.setDate("12-10-2020");
		flightInfo.setTicketPrice(1263.8);
		try {
			boolean expectedFlag = admi.addFlightCheck(113);
			assertEquals(expectedFlag, false);
		} catch (Exception e) {
			assertThrows(AddFlightException.class, () -> {
				admi.addFlightCheck(113);
			});
		}
		return;
	}
	@Test
	void updateFlightCheckTest() {
		flightInfo=new Flight();
		flightInfo.setFlightId(114);
		flightInfo.setFlightName("indigooo");
		flightInfo.setSource("bgaluru");
		flightInfo.setDestination("delhii");
		flightInfo.setTotalNoOfseats(13);
		flightInfo.setDate("11-11-2020");
		flightInfo.setTicketPrice(1223.8);
		try {
			boolean expectedFlag=admi.updateFlightCheck(114);
			assertEquals(expectedFlag, false);
		}catch(Exception e){
			assertThrows(AddFlightException.class,()->{
				admi.updateFlightCheck(114);
			});
		}
		return;
	}
	@Test
	List<Passenger> viewPassengerTest() {
		List<Passenger> passenger = admi.viewPassenger();
		assertNotNull(passenger);
		return passenger;
	}
	@Test
	List<Flight> viewFlightTest() {
		List<Flight> flight = admi.viewFlight();
		assertNotNull(flight);
		return flight;
	}



}
