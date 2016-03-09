package org.startupfactory.instantmessaging;

/**
 * Throws UsedUsernameException when user is trying to connect with username
 * that already exist in the username list.
 * 
 * @author Rado
 *
 */
public class UsedUsernameException extends Exception {
	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Parameterless constructor.
	 */
	public UsedUsernameException() {
		InstantMessagingClient.getInstance().startClient();
	}

	/**
	 * Constructor that accepts a message.
	 * 
	 * @param string
	 *            message which will be sent when user is trying to connect with
	 *            username that already exist.
	 */
	public UsedUsernameException(String string) {
		super(string);
		InstantMessagingClient.getInstance().startClient();
	}
}
