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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The client side where client establish connection to the server.
 * 
 * @author Rado
 *
 */
public class InstantMessagingClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(InstantMessagingClient.class);
	private static final String LETTERS = "[a-zA-Z0-9]{3,10}";
	private static final Pattern PATTERN = Pattern.compile(LETTERS);
	private static InstantMessagingClient client;
	private static boolean userLeft = false;
	private String userName;

	/**
	 * Parameterless constructor.
	 */
	private InstantMessagingClient() {
	}

	/**
	 * Method which returns the instance of the client.
	 * 
	 * @return client socket.
	 */
	public static synchronized InstantMessagingClient getInstance() {
		if (client == null) {
			client = new InstantMessagingClient();
		}
		return client;
	}

	/**
	 * Starts connection of the client to the server. Asks for username which
	 * should contain at least 3 characters and max 10 characters. And can
	 * contain letters and numbers. If the username is correct it will be send
	 * to the server. If server respond with acceptance of the name chat will
	 * began.
	 */
	public void startClient() {
		Socket socket = null;
		Scanner console = null;
		try {
			PrintWriter out;
			BufferedReader in;
			console = new Scanner(System.in);

			LOGGER.info("Write your username:");
			userName = console.nextLine().trim();

			if (checkUsername(userName) == true) {
				socket = new Socket("localhost", 8090);
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

				out.println(userName);
				String answer = in.readLine();

				if (!answer.equals("The username already exist.")) {
					ServerMessagesListenerWorker worker = new ServerMessagesListenerWorker(socket);
					Thread thread = new Thread(worker);
					thread.start();
					LOGGER.info("Server: {}", answer);
					String oneline = "";
					while (((oneline = console.nextLine().trim()) != null) && (!oneline.equalsIgnoreCase("end"))) {
						out.println(oneline);
					}
					worker.setWorkerWorking(false);
				} else {
					LOGGER.info("The username already exist.");
					try {
						throw new UsedUsernameException();
					} catch (UsedUsernameException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					LOGGER.error("The username is incorrect!It must contain at lest 3 to 10 characters and numbers.");
					throw new IncorectUsernameException("The username is incorect!");
				} catch (IncorectUsernameException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			LOGGER.error("IOException:", e);
		} finally {
			try {
				userLeft = true;
				socket.close();

			} catch (IOException e) {
				LOGGER.error("Can't close socket:", e);
			}
			console.close();
		}
	}

	/**
	 * Checks if username fills the requirements.
	 * 
	 * @param userName
	 *            which will be checked.
	 * @return
	 */
	private boolean checkUsername(String userName) {
		boolean check = false;
		Matcher matcher = PATTERN.matcher(userName);
		if (matcher.find()) {
			check = true;
		}
		return check;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userLeft
	 */
	public static boolean isUserLeft() {
		return userLeft;
	}
}
