package org.startupfactory.homework3.consolenumreading;

/**
 * Throws OutsideBoundsException when the number entered by console is bigger
 * than 100
 * 
 * @author Rado
 *
 */
public class OutsideBoundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8748838701635270687L;

	/**
	 * Parameterless Constructor
	 */
	public OutsideBoundsException() {
	}

	/**
	 * Constructor that accepts a message
	 * 
	 * @param message
	 *            accepts string
	 */
	public OutsideBoundsException(String message) {
		super(message);
	}
}
