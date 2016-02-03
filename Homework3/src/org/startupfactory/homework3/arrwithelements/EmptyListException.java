/**
 * 
 */
package org.startupfactory.homework3.arrwithelements;

/**
 * Throws EmptyListException when trying to remove element from the array but it
 * is empty.
 * 
 * @author Rado
 *
 */
public class EmptyListException extends Exception {
	private static final long serialVersionUID = -726107747785428355L;

	/**
	 * Parameterless Constructor
	 */
	public EmptyListException() {
	}

	/**
	 * Constructor that accepts a message
	 * 
	 * @param message
	 *            accepts string
	 */
	public EmptyListException(String message) {
		super(message);
	}

	/**
	 * Constructor that accept a message and exception to throw
	 * 
	 * @param message
	 *            accepts string
	 * @param e
	 *            accepts throwable
	 */
	public EmptyListException(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * Constructor that accept only exception to throw
	 * 
	 * @param e
	 *            accepts throwable
	 */
	public EmptyListException(Throwable e) {
		super(e);
	}
}
