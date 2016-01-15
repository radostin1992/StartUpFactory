/**
 * 
 */
package org.startupfactory.homework2.buildhouse;

import kareltherobot.Robot;

/**
 * @author Rado
 *
 */
public class RightTurner extends Robot {
	/**
	 * Inherited constructor
	 * 
	 * @param street
	 * @param avenue
	 * @param direction
	 * @param beepers
	 */
	public RightTurner(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	/*
	 * Methot which helps to turn robot to the right direction
	 */
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

}
