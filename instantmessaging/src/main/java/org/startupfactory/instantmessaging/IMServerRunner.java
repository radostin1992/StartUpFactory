/**
 * 
 */
package org.startupfactory.instantmessaging;

/**
 * Class which start the server.
 * 
 * @author Rado
 *
 */
public class IMServerRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InstantMessagingServer.getInstance().startServer();
	}

}
