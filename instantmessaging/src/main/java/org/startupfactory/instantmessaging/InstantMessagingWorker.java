/**
 * 
 */
package org.startupfactory.instantmessaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread responsible for monitoring client messages.
 * 
 * @author Rado
 *
 */
public class InstantMessagingWorker implements Runnable {
	private Socket socket;
	private String userName;
	private ArrayList<Socket> clientList = InstantMessagingServer.getInstance().getClientList();
	PrintWriter out;

	private static final Logger LOGGER = LoggerFactory.getLogger(InstantMessagingWorker.class);

	/**
	 * Constructor
	 * 
	 * @param socket
	 *            sets the connection
	 * @param userName
	 *            of the client
	 */
	public InstantMessagingWorker(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
	}

	/**
	 * Thread which notify all users that someone connected or disconnected from
	 * the server. Or just sending a message.
	 */
	@Override
	public void run() {
		clientList.remove(socket);
		LOGGER.info("'{}' is online", userName);
		sendToAll("'" + userName + "'" + " is now online!");
		clientList.add(socket);
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

			String clientInput = "";
			InstantMessagingClient.getInstance();
			while ((clientInput = in.readLine()) != null && InstantMessagingClient.isUserLeft() == false) {

				LOGGER.info("{}:'{}', says: {}", getCurrentTimeStamp(), userName, clientInput);

			}
			LOGGER.info("'{}' left the server!", userName);
			sendToAll("'" + userName + "'" + " left the server!");
			InstantMessagingServer.getUsersOnline().remove(userName);

		} catch (Exception e) {
			try {
				throw new LostConnectionException("Lost connection with '" + userName + "'!");
			} catch (LostConnectionException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Define the output stream.
	 * 
	 * @param obj
	 *            is the message to send.
	 * @param client
	 *            the socket which message will be send.
	 */
	public void write(String obj, Socket client) {
		try {
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
	}

	/**
	 * Sends message to all users in the clients list.
	 * 
	 * @param message
	 *            which server wants to send.
	 */
	public void sendToAll(String message) {
		for (Socket client : clientList) {
			write(message, client);
		}
	}

	/**
	 * Method for getting current time stamp in specific format.
	 * 
	 * @return current time stamp.
	 */
	public String getCurrentTimeStamp() {
		return new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
	}

}
