package org.startupfactory.instantmessaging;

public class CloseWorkingThreadsException extends Exception {

	/**
	 * Throws CloseWorkingThreadsException when user left.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that accepts a message.
	 * 
	 * @param string
	 *            message which is sent when user left.
	 */
	public CloseWorkingThreadsException(String string) {
		super(string);
	}

}
