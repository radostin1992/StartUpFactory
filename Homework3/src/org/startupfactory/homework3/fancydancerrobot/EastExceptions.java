package org.startupfactory.homework3.fancydancerrobot;

/**
 * Throws EastExceptions when robot turns at east
 * 
 * @author Rado
 *
 */
public class EastExceptions extends Exception {
	private static final long serialVersionUID = -2976269371255934600L;

	/**
	 * Constructor that accepts message
	 * 
	 * @param message
	 *            accepts string
	 */
	public EastExceptions(String message) {
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
	public EastExceptions(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * Constructor that accepts exception
	 * 
	 * @param e
	 *            accepts exception
	 */
	public EastExceptions(Throwable e) {
		super(e);
	}
}
