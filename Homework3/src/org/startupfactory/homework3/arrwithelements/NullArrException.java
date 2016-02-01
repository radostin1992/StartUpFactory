/**
 * 
 */
package org.startupfactory.homework3.arrwithelements;

/**
 * TODO: document.
 * 
 * @author Rado
 *
 */
public class NullArrException extends Exception {
	private static final long serialVersionUID = -726107747785428355L;

	// TODO: use javadoc for those.
	// Parameterless Constructor
	public NullArrException() {
	}

	// TODO: use javadoc for those.
	// Constructor that accepts a message
	public NullArrException(String message) {
		super(message);
	}

	public NullArrException(String message, Throwable e) {
		super(message, e);
	}

	public NullArrException(Throwable e) {
		super(e);
	}
}
