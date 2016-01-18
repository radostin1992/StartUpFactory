package org.startupfactory.homework3.consolenumreading;

public class OutsideBoundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8748838701635270687L;

	// Parameterless Constructor
	public OutsideBoundsException() {
	}

	// Constructor that accepts a message
	public OutsideBoundsException(String message) {
		super(message);
	}
}
