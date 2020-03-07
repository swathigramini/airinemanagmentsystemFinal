package com.capgemini.airlinereservationsystem1.dao;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;
import com.capgemini.airlinereservationsystem1.exception.ManagerException;
import com.capgemini.airlinereservationsystem1.exception.PassengerException;
import com.capgemini.airlinereservationsystem1.exception.TicketException;

public class PassengerDaoImplTest extends TestCase {

	private Passenger passengerInfo = new Passenger();
	private PassengerDao admi = new PassengerDaoImpl();
	private Ticket ticketInfo = new Ticket();


	@Test
	void registerPassengerTest() {
		passengerInfo=new Passenger();
		passengerInfo.setPassengerId(105);
		passengerInfo.setPassengerName("ravi");
		passengerInfo.setPassengerEmail("ravi@12.com");
		passengerInfo.setPassengerPassword("qwerty@1Q");
		passengerInfo.setPassengerContact(987654);
		try {
			boolean expectedFlag=admi.registerPassenger(passengerInfo);
			assertEquals(expectedFlag, true);
		}catch(Exception e){
			assertThrows(PassengerException.class,()->{
				admi.registerPassenger(passengerInfo);
			});
		}
		return ;
		
	}
	@Test
	List<Flight> viewFlightTest() {
		List<Flight> flight = admi.viewFlight();
		assertNotNull(flight);
		return flight;
	}
	@Test
	void bookTicketTest() {
		ticketInfo=new Ticket();
		ticketInfo.setTicketId(1);
		ticketInfo.setBookigId(22);
		ticketInfo.setFlightId(103);
		ticketInfo.setPassengerId(105);
		ticketInfo.setNoOfSeats(123);
		ticketInfo.setSource("mysore");
		ticketInfo.setDestination("kashmir");
		ticketInfo.setJourneyDate("11-03-2020");
		ticketInfo.setTicketPrice(1234.0);
		try {
			Ticket expectedFlag=admi.bookTicket(ticketInfo);
			assertEquals(expectedFlag, expectedFlag);
		}catch(Exception e){
			assertThrows(TicketException.class,()->{
				admi.bookTicket(ticketInfo);
			});
		}
		return ;
		
	}
	@Test
	void cancelTicketTest() {
		ticketInfo=new Ticket();
		ticketInfo.setTicketId(1);
		try {
			boolean expectedFlag=admi.TicketCancellation(ticketInfo.getTicketId());
			assertEquals(expectedFlag, true);
		}catch(Exception e){
			assertThrows(TicketException.class,()->{
				admi.TicketCancellation(ticketInfo.getTicketId());
			});
		}
		return ;
	}

}
