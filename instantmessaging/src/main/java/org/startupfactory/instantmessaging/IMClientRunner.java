/**
 * 
 */
package org.startupfactory.instantmessaging;

/**
 * Class which start the client chat.
 * 
 * @author Rado
 *
 */
public class IMClientRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InstantMessagingClient.getInstance().startClient();
	}

}
