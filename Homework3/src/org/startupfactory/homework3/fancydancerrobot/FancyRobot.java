/**
 * 
 */
package org.startupfactory.homework3.fancydancerrobot;

import kareltherobot.Directions;
import kareltherobot.Robot;

/**
 * Robot who don't stop when found a wall and throw exception when it is being
 * blinded by the sun;
 * 
 * @author Rado
 *
 */
public class FancyRobot extends Robot {
	/**
	 * Inherited constructor
	 * 
	 * @param street
	 *            starting position to x coordinate
	 * @param avenue
	 *            starting position to y coordinate
	 */
	public FancyRobot(int street, int avenue) {
		super(street, avenue, Directions.North, 0);
	}

	/**
	 * Moves the robot
	 * 
	 * @throws FoundWallException
	 *             when robot found wall
	 * @throws EastExceptions
	 *             when robot turns to east
	 */
	public void carefulMove() throws FoundWallException, EastExceptions {
		if (facingEast()) {
			throw new EastExceptions("The robot was blinded by the sun");
		} else if (!frontIsClear()) {
			throw new FoundWallException("The robot found a wall");
		} else
			super.move();

	}

}
