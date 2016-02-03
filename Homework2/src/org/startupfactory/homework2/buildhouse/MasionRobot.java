/**
 * 
 */
package org.startupfactory.homework2.buildhouse;

/**
 * Robot which builds the basics of the house;
 * 
 * @author Rado
 *
 */
public class MasionRobot extends RightTurner implements HouseBuilder {

	/**
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
	public MasionRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	/**
	 * Method which helps building the basics of the house
	 */
	@Override
	public void buld() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 14; j++) {
				putBeeper();
				move();

			}
			turnRight();
		}
	}

}
