package com.fssa.freshfood.exceptions;


public class InvalidUserException extends Exception {
	/**
	 * Creating Custom Exception for DAOException 
	 */
	private static final long serialVersionUID = -8105491977357554060L;
	/**
	 *  Calling each super constructors for each of the types
	 */
	
	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable te) {
		super(te);
	}

	public InvalidUserException(String msg, Throwable te) {
		super(msg, te);
	}
}