/**
 * 
 */
package org.startupfactory.instantmessaging;

/**
 * Throws IncorectUsernameException when username which user fill don't match to
 * the requirements.
 * 
 * @author Rado
 *
 */
public class IncorectUsernameException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Parameterless constructor.
	 */
	public IncorectUsernameException() {
		InstantMessagingClient.getInstance().startClient();
	}

	/**
	 * Constructor that accepts message.
	 * 
	 * @param string
	 *            message which is sent when user fills incorrect username.
	 */
	public IncorectUsernameException(String string) {
		super(string);
		InstantMessagingClient.getInstance().startClient();
	}

}
