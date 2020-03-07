package com.capgemini.airlinereservationsystem1.controller;

import java.util.Scanner;

import com.capgemini.airlinereservationsystem1.bean.Admin;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.exception.AdminException;
import com.capgemini.airlinereservationsystem1.exception.InputMismatchException;
import com.capgemini.airlinereservationsystem1.exception.ManagerException;
import com.capgemini.airlinereservationsystem1.exception.PassengerException;
import com.capgemini.airlinereservationsystem1.service.AdminService;
import com.capgemini.airlinereservationsystem1.service.AdminServiceImpl;
import com.capgemini.airlinereservationsystem1.validation.Validator;

public class AirlineReservationSystemController {
	static Validator validator = new Validator();

	static int numValidate(String str) {
		if (Validator.numValidate(str)) {
			return Integer.parseInt(str);
		} else {
			System.out.println("Enter numeric type only");
			return 0;
		}

	}

	public static void main(String[] args) throws PassengerException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("**************************************");
		System.out.println("Welcome To AirLine Managment Service");
		System.out.println("**************************************");
		
		while (true) {
			System.out.println("Option 1 : Admin Login");
			System.out.println("Option 2 : Manager Login");
			System.out.println("Option 3 : Passenger Login");
			System.out.println("Option 4 : Register Passenger");
			
            int choice =AirlineReservationSystemController.numValidate (scanner.next());
			AdminService serviceAdmin = new AdminServiceImpl();
			
			if (choice == 1) {
				Admin admin = null;
				try {
					admin = AdminController.adminLogin();
				} catch (AdminException msg) {
					System.out.println("The given UserName or Password is wrong" + msg);
					System.out.println(msg.getMessage());
				}

			} else if (choice == 2) {
				Manager manager = null;
				try {
					manager = ManagerController.managerLogin();
				} catch (ManagerException e) {
					System.out.println(e.getMessage());

				}

			} else if (choice == 3) {
				Passenger passenger = null;
				try {
					passenger = PassengerController.passengerLogin();
				} catch (PassengerException e) {
					System.out.println(e.getMessage());
				}

			} else if(choice == 4){
				Passenger passenger = null;
				passenger = PassengerController.registerPassenger();
			}

		}
	}

}
