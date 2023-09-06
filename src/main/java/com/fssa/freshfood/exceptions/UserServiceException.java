package com.fssa.freshfood.exceptions;

public class UserServiceException extends Exception {
	/**
	 * Creating Custom Exception for DAOException 
	 */
	private static final long serialVersionUID = -8105491977357554060L;
	/**
	 *  Calling each super constructors for each of the types
	 */
	
	public UserServiceException(String msg) {
		super(msg);
	}

	public UserServiceException(Throwable te) {
		super(te);
	}

	public UserServiceException(String msg, Throwable te) {
		super(msg, te);
	}
}