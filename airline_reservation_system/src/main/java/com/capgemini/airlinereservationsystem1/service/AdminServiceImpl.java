package com.capgemini.airlinereservationsystem1.service;

import java.util.List;

import com.capgemini.airlinereservationsystem1.bean.Manager;
import com.capgemini.airlinereservationsystem1.bean.Passenger;
import com.capgemini.airlinereservationsystem1.dao.AdminDao;
import com.capgemini.airlinereservationsystem1.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService{
	
	AdminDao adminDao=new AdminDaoImpl();

	public boolean adminLogin(int adminId, String adminPassword) {
		return adminDao.adminLogin(adminId, adminPassword);
	}

	public boolean addManager(Manager manager) {
		return adminDao.addManager(manager);
	}

	public boolean addFlightCheck(int managerId) {
		return adminDao.addFlightCheck(managerId);
	}

	public boolean deleteManager(int managerId) {
		return adminDao.deleteManager(managerId);
	}

	public boolean updateFlightCheck(int managerId) {
		return adminDao.updateFlightCheck(managerId);
	}

	public void updateManager(Manager manager) {
		return;
	}

	public List<Manager> viewManager() {
		return adminDao.viewManager();
	}


}
