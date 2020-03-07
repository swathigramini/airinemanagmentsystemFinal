package com.capgemini.airlinereservationsystem1.dao;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.exception.AddFlightException;
import com.capgemini.airlinereservationsystem1.exception.ManagerException;

public class AdminDaoImplTest extends TestCase {
	private Manager managerInfo=new Manager();	
	private AdminDao admi=new AdminDaoImpl();
	private Flight flightInfo=new Flight();

	@Test
	void adminLoginTest() {
		boolean b=admi.adminLogin(101, "qwerty");
		assertEquals(false,b);
	}
	@Test
	void addManagerTest() {
		managerInfo=new Manager();
		managerInfo.setManagerId(111);
		managerInfo.setManagerName("ram");
		managerInfo.setManagerEmail("abc@abc.com");
		managerInfo.setManagerPassword("qwerty@1Q");
		managerInfo.setManagerContact(345678987);
		try {
			boolean expectedFlag=admi.addManager(managerInfo);
			assertEquals(expectedFlag, true);
		}catch(Exception e){
			assertThrows(ManagerException.class,()->{
				admi.addManager(managerInfo);
			});
		}
		
	}
	@Test
	void addFlightCheckTest() {
		flightInfo=new Flight();
		flightInfo.setFlightId(113);
		flightInfo.setFlightName("indigo");
		flightInfo.setSource("bengaluru");
		flightInfo.setDestination("delhi");
		flightInfo.setTotalNoOfseats(12);
		flightInfo.setDate("12-11-2020");
		flightInfo.setTicketPrice(1233.8);
		try {
			boolean expectedFlag=admi.addFlightCheck(113);
			assertEquals(expectedFlag, false);
		}catch(Exception e){
			assertThrows(AddFlightException.class,()->{
				admi.addFlightCheck(113);
			});
		}
		
	}
	@Test
	void deleteManagerTest() {
		managerInfo=new Manager();
		managerInfo.setManagerId(111);
		try {
			boolean expectedFlag=admi.deleteManager(managerInfo.getManagerId());
			assertEquals(expectedFlag, false);
		}catch(Exception e){
			assertThrows(ManagerException.class,()->{
				admi.deleteManager(managerInfo.getManagerId());
			});
		}
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
	}
	
	@Test
	@Disabled
	void updateManagerTest() {
		managerInfo=new Manager();
		managerInfo.setManagerId(112);
		managerInfo.setManagerName("ramu");
		managerInfo.setManagerEmail("abc@bbc.com");
		managerInfo.setManagerPassword("qwerty@1Q");
		managerInfo.setManagerContact(346778987);
		try {
			boolean expectedFlag=admi.updateManager(managerInfo);
			assertEquals(expectedFlag, managerInfo);
		}catch(Exception e){
			assertThrows(ManagerException.class,()->{
				admi.addManager(managerInfo);
			});
		}
	}
	@Test
	void viewManagerTest() {
		List<Manager> manager = admi.viewManager();
		assertNotNull(manager);
	}

}


