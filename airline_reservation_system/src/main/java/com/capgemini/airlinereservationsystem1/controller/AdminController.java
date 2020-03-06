package com.capgemini.airlinereservationsystem1.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.airlinereservationsystem1.bean.Admin;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.exception.AdminException;
import com.capgemini.airlinereservationsystem1.service.AdminService;
import com.capgemini.airlinereservationsystem1.service.AdminServiceImpl;
import com.capgemini.airlinereservationsystem1.service.ManagerService;
import com.capgemini.airlinereservationsystem1.service.ManagerServiceImpl;
import com.capgemini.airlinereservationsystem1.validation.Validator;

public class AdminController {
	static Scanner scanner = new Scanner(System.in);
	static AdminService serviceAdmin = new AdminServiceImpl();
	static ManagerService serviceManager = new ManagerServiceImpl();
	static Validator validator = new Validator();
	static Manager manager = new Manager();
	static Admin admin = new Admin();

	public static Admin adminLogin() throws AdminException {
		int adminId = 0;
		try {
			System.out.println("Enter admin id");
			while (true) {
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					adminId = sId;
					break;
				} else {
					System.out.println("Id should be Integer");
				}
			}
			System.out.println("Enter admin password");
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

			admin.setAdminPassword(password);
			boolean adminLogin1 = serviceAdmin.adminLogin(adminId, password);
			if (adminLogin1) {
				System.out.println("Login successfully");
				getAdminFunction();
			} else {
				throw new AdminException("Invalid username and password for admin");
			}
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}// end of adminLogin()

	private static void getAdminFunction() {

		System.out.println("select a option");
		System.out.println("1. Add manager");
		System.out.println("2. Update manager");
		System.out.println("3. Display all manager details");
		System.out.println("4. Delete manager");
		System.out.println("5. Logout");
		int adminChoice = AirlineReservationSystemController.numValidate(scanner.next());

		switch (adminChoice) {

		case 1:
			try {
				addManager();
			} catch (AdminException e) {
				System.out.println("admin already exists");
			}
			break;

		case 2:
			updateManager();
			break;
		case 3:
			viewManager();
			break;

		case 4:
			deleteManager();
			break;

		case 5:
			String a[] = new String[] { "1" };
			AirlineReservationSystemController.main(a);
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}// end of switch case
	}

	public static void addManager() throws AdminException {

		try {
			int managerId = 0;
			while (true) {
				System.out.println("Enter the manager id");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					managerId = sId;
					manager.setManagerId(managerId);
					break;
				} else {
					System.out.println("Id should be only an Integer");
				}
			}

			boolean addFlighCheck = serviceAdmin.addFlightCheck(managerId);
			if (addFlighCheck) {
				System.out.println("this manager id is used by someother flight give another one");
				int managerId1 = 0;
				while (true) {
					System.out.println("Enter another manager id");
					Integer sId = validator.validateId(scanner.next());
					if (sId != null) {
						managerId1 = sId;
						manager.setManagerId(managerId1);
						break;
					} else {
						System.out.println("Id should be only an Integer");
					}
				}
			}

			System.out.println("Enter manager name");
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
			manager.setManagerName(name);

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
			manager.setManagerEmail(email);

			System.out.println("Enter manager contact number");
			manager.setManagerContact(scanner.nextLong());

			boolean manager2 = serviceAdmin.addManager(manager);
			if (manager2) {
				System.out.println("record inserted");
				System.out.println("press 0 to go back");
				int option = scanner.nextInt();
				if (option == 0) {
					getAdminFunction();
				}
			} else {
				throw new AdminException("Record is already present");
			}

		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}// end of add manager()

	public static void deleteManager() {
		try {

			int managerIdDelete = 0;
			while (true) {
				System.out.println("Enter manager id you want to delete");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					managerIdDelete = sId;
					break;
				} else {
					System.out.println("Id should be only an Integer");
				}
			}
			boolean deleteManager = serviceAdmin.deleteManager(managerIdDelete);
			if (deleteManager) {
				System.out.println("record deleted");
				System.out.println("press 0 to go back");
				int option = scanner.nextInt();
				if (option == 0) {
					getAdminFunction();
				}

			} else {
				throw new AdminException("Record is not present");
			}

		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}

	}// end of delete manager

	public static void updateManager() {
		try {
			int managerId = 0;
			while (true) {
				System.out.println("Enter the manager id");
				Integer sId = validator.validateId(scanner.next());
				if (sId != null) {
					managerId = sId;
					manager.setManagerId(managerId);
					break;
				} else {
					System.out.println("Id should be only an Integer");
				}
			}
			boolean addFlighCheck = serviceAdmin.updateFlightCheck(managerId);
			if (addFlighCheck) {
				System.out.println("Enter manager name");
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
				manager.setManagerName(name);
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
				manager.setManagerEmail(email);

				System.out.println("Enter manager contact number");
				manager.setManagerContact(scanner.nextLong());

				boolean addManager = serviceAdmin.addManager(manager);
				if (addManager) {
					System.out.println("record updated");
					System.out.println("press 0 to go back");
					int option = scanner.nextInt();
					if (option == 0) {
						getAdminFunction();
					}
				} else {
					throw new AdminException("Record is already present");
				}
			}

		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}

	}// end of update manager()

	public static void viewManager() {
		List<Manager> managerData = new LinkedList<>();
		managerData = serviceAdmin.viewManager();
		if (managerData == null) {
			System.out.println("No records present");
		} else {
			for (Manager manager : managerData) {
				System.out.println("Manager id= " + manager.getManagerId());
				System.out.println("manager name= " + manager.getManagerName());
				System.out.println("manager contact =" + manager.getManagerContact());
				System.out.println("manager email =" + manager.getManagerEmail());
				System.out.println("-----------------------------------------------");
			}
			System.out.println("press 0 to exit");
			int option = scanner.nextInt();
			if (option == 0) {
				getAdminFunction();
			}
		}
	}// end of all manager details

}
