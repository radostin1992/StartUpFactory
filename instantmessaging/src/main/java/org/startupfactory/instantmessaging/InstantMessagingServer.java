/**
 * 
 */
package org.startupfactory.instantmessaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main server where chat between clients happens.
 * 
 * @author Rado
 *
 */

public class InstantMessagingServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(InstantMessagingServer.class);
	private static InstantMessagingServer server;
	private static ArrayList<String> usersOnline = new ArrayList<>();
	private ArrayList<Socket> clientList = new ArrayList<>();

	/**
	 * Parameterless constructor.
	 */
	private InstantMessagingServer() {
	}

	/**
	 * Method which returns the instance of the server.
	 * 
	 * @return server socket
	 */
	public static synchronized InstantMessagingServer getInstance() {
		if (server == null) {
			server = new InstantMessagingServer();
		}
		return server;
	}

	/**
	 * Start the server. Adds clients to the list. Welcomes the new clients.
	 * Start threat to monitor messages, which client sends.
	 */
	public void startServer() {

		try (ServerSocket server = new ServerSocket(8090)) {
			LOGGER.info("Server started!");
			BufferedReader in;
			PrintWriter out;

			while (true) {
				Socket client = server.accept();
				clientList.add(client);
				in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
				out = new PrintWriter(client.getOutputStream(), true);

				String user = in.readLine().trim();
				if (usersOnline.contains(user) == false) {

					if (usersOnline.size() < 1) {
						out.println("Welcome to the server! No users online.");
					} else {
						out.println("Welcome to the server! People online: " + usersOnline.toString());
					}

					usersOnline.add(user);
					LOGGER.info("{} is trying to connect...", user);
					InstantMessagingWorker worker = new InstantMessagingWorker(client, user);
					Thread thread = new Thread(worker);
					thread.start();

				} else {
					out.println("The username already exist.");
				}

			}
		} catch (IOException e) {
			LOGGER.error("Something unexpected happened!", e);
		}
	}

	/**
	 * @return the clientList
	 */
	public ArrayList<Socket> getClientList() {
		return clientList;
	}

	/**
	 * @param clientList
	 *            the clientList to set
	 */
	public void setClientList(ArrayList<Socket> clientList) {
		this.clientList = clientList;
	}

	/**
	 * @return the usersOnline
	 */
	public static ArrayList<String> getUsersOnline() {
		return usersOnline;
	}

	/**
	 * @param usersOnline
	 *            the usersOnline to set
	 */
	public static void setUsersOnline(ArrayList<String> usersOnline) {
		InstantMessagingServer.usersOnline = usersOnline;
	}

}
