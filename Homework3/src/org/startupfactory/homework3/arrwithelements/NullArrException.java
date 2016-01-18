/**
 * 
 */
package org.startupfactory.homework3.arrwithelements;

/**
 * @author Rado
 *
 */
public class NullArrException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -726107747785428355L;

	// Parameterless Constructor
	public NullArrException() {
	}

	// Constructor that accepts a message
	public NullArrException(String message) {
		super(message);
	}
}
