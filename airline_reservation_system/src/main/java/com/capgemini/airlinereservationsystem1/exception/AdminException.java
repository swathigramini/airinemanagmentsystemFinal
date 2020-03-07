package com.capgemini.airlinereservationsystem1.exception;

public class AdminException extends Exception{
	
	String msg = "Record already Present";
	public AdminException(String msg) {
		super(msg);
	}

}
