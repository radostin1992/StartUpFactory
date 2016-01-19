package org.startupfactory.homework3.fancydancerrobot;

public class EastExceptions extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2976269371255934600L;

	public EastExceptions(String message) {
		super(message);
	}

	public EastExceptions(String message, Throwable e) {
		super(message, e);
	}

	public EastExceptions(Throwable e) {
		super(e);
	}
}
