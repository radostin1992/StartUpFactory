package org.startupfactory.homework3.consolenumreading;

public class UnderBoundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2271667257418812917L;

	// Parameterless Constructor
	public UnderBoundsException() {
	}

	// Constructor that accepts a message
	public UnderBoundsException(String message) {
		super(message);
	}
}
