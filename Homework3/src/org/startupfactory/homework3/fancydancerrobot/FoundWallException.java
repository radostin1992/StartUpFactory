/**
 * 
 */
package org.startupfactory.homework3.fancydancerrobot;

/**
 * TODO: document.
 * 
 * @author Rado
 *
 */
public class FoundWallException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FoundWallException(String message) {
		super(message);
	}

	public FoundWallException(String message, Throwable e) {
		super(message, e);
	}

	public FoundWallException(Throwable e) {
		super(e);
	}

}
