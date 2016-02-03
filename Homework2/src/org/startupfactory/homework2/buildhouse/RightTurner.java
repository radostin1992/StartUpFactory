
package org.startupfactory.homework2.buildhouse;

import kareltherobot.Robot;

/**
 * Turns the robot to the right direction
 * 
 * @author Rado
 *
 */
public class RightTurner extends Robot {

	/**
	 * 
	 * Inherited constructor
	 * 
	 * @param street
	 *            starting position to x coordinate
	 * @param avenue
	 *            starting position to y coordinate
	 * @param direction
	 *            initial direction
	 * @param beepers
	 *            number of the beepers which robot hold for putting them
	 */
	public RightTurner(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	/**
	 * Method which helps to turn robot to the right direction
	 */
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

}
