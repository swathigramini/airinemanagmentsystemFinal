package com.capgemini.airlinereservationsystem1.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.airlinereservationsystem1.bean.Admin;
import com.capgemini.airlinereservationsystem1.bean.Availability;
import com.capgemini.airlinereservationsystem1.bean.Flight;
import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.bean.Ticket;
import com.capgemini.airlinereservationsystem1.db.Repository;

public class AdminDaoImpl implements AdminDao {
	Repository repository = new Repository();

	private HashMap<Integer, Admin> adminData = repository.adminData;
	private HashMap<Integer, Manager> managerData = repository.managerData;

	public boolean adminLogin(int adminId, String adminPassword) {
		try {
			Iterator<Map.Entry<Integer, Admin>> iterator = adminData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Admin> entry = iterator.next();
				if (adminId == (entry.getValue().getAdminId())
						&& adminPassword.equals(entry.getValue().getAdminPassword())) {

					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of adminLogin

	public boolean addManager(Manager manager) {
		try {

			Integer i = 0;
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Manager> entry = iterator.next();
				i = entry.getKey();
			}

			managerData.put(i + 1, manager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of addFlightOwner

	public boolean addFlightCheck(int managerId) {
		try {
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Manager> entry = iterator.next();
				if (managerId == (entry.getValue().getManagerId())) {
					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of addFlightCheck

	public boolean deleteManager(int managerId) {
		try {
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Manager> entry = iterator.next();

				if (managerId == (entry.getValue().getManagerId())) {
					iterator.remove();
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}// end of delete Manager

	public boolean updateFlightCheck(int managerId) {
		try {
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Manager> entry = iterator.next();

				if (managerId == (entry.getValue().getManagerId())) {
					iterator.remove();
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// end of updateFlightCheck

	public boolean updateManager(Manager manager) {
		try {
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<Integer, Manager> entry = iterator.next();
				if (manager.getManagerId() == (entry.getValue().getManagerId())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
   return false;
	}// end of updateOwner

	public List<Manager> viewManager() {
		try {
       List<Manager> manager = new LinkedList<>();
			Iterator<Map.Entry<Integer, Manager>> iterator = managerData.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry<Integer, Manager> entry = iterator.next();
				manager.add(entry.getValue());
			}
			return manager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of viewManager

}
