package org.startupfactory.homework3.consolenumreading;

/**
 * Throws UnderBoundsException when the number entered by console is smaller
 * than zero
 * 
 * @author Rado
 *
 */
public class UnderBoundsException extends Exception {

	private static final long serialVersionUID = -2271667257418812917L;

	/**
	 * Parameterless Constructor
	 */
	public UnderBoundsException() {
	}

	/**
	 * Constructor that accepts a message
	 * 
	 * @param message
	 *            accepts string
	 */
	public UnderBoundsException(String message) {
		super(message);
	}
}
