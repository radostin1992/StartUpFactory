package org.startupfactory.homework3.arrwithelements;

public class FullArrException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8294594087128324453L;

	// Parameterless Constructor
	public FullArrException() {
	}

	// Constructor that accepts a message
	public FullArrException(String message) {
		super(message);
	}
}
