/**
 * 
 */
package org.startupfactory.instantmessaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread which listen for messages from the server.
 * 
 * @author Rado
 *
 */
public class ServerMessagesListenerWorker implements Runnable {
	private Socket socket;
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerMessagesListenerWorker.class);
	private BufferedReader in;
	private boolean isWorkerWorking = true;

	/**
	 * Starts the thread.
	 * 
	 * @throws CloseWorkingThreadsException
	 *             when the user left without improperly.
	 */
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			String message;
			while (isWorkerWorking == true) {
				try {
					message = in.readLine();
					LOGGER.info("Server: {}", message);
				} catch (Exception e) {
					try {
						in.close();
						throw new CloseWorkingThreadsException("Closing working threads!");
					} catch (CloseWorkingThreadsException e1) {
						e1.printStackTrace();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param isWorkerWorking
	 *            the isWorkerWorking to set
	 */
	public void setWorkerWorking(boolean isWorkerWorking) {
		this.isWorkerWorking = isWorkerWorking;
	}

	public ServerMessagesListenerWorker(Socket socket) {
		this.socket = socket;
	}

}
