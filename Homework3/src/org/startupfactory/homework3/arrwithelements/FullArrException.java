package org.startupfactory.homework3.arrwithelements;

/**
 * Throws FullArrException when trying to add new element to the array but it is
 * full.
 * 
 * @author Rado
 *
 */
public class FullArrException extends Exception {

	private static final long serialVersionUID = 8294594087128324453L;

	/**
	 * Parameterless Constructor
	 */
	public FullArrException() {
	}

	/**
	 * Constructor that accepts a message
	 * 
	 * @param message
	 *            accepts string
	 */
	public FullArrException(String message) {
		super(message);
	}
}
