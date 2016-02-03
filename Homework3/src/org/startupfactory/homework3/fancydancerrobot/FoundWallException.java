
package org.startupfactory.homework3.fancydancerrobot;

/**
 * Throws FoundWallException when the robot finds wall on his path
 * 
 * @author Rado
 *
 */
public class FoundWallException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that accepts message
	 * 
	 * @param message
	 *            accepts string
	 */
	public FoundWallException(String message) {
		super(message);
	}

	/**
	 * Constructor that accepts message and exception
	 * 
	 * @param message
	 *            accepts string
	 * @param e
	 *            accepts exception
	 */
	public FoundWallException(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * Constructor that accepts exception
	 * 
	 * @param e
	 *            accepts exception
	 */
	public FoundWallException(Throwable e) {
		super(e);
	}

}
