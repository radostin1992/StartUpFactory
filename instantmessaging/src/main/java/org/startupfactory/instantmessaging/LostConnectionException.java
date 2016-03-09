/**
 * 
 */
package org.startupfactory.instantmessaging;

/**
 * Throws LostConnectionException when user left the server unexpectedly.
 * 
 * @author Rado
 *
 */
public class LostConnectionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that accepts message
	 * 
	 * @param string
	 *            message which will be sent when user left server unexpectedly.
	 */
	public LostConnectionException(String string) {
		super(string);
	}
}
