/**
 * 
 */
package org.startupfactory.homework2.buildhouse;

/**
 * The robot which builds the roof of the house;
 * 
 * @author Rado
 *
 */
public class RoofBuilderRobot extends RightTurner implements HouseBuilder {
	/**
	 * @param street
	 *            starting position to x coordinate
	 * @param avenue
	 *            starting position to y coordinate
	 * @param direction
	 *            initial direction
	 * @param beepers
	 *            number of the beepers which robot hold for putting them
	 */
	public RoofBuilderRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	/**
	 * Method which helps building the roof of the house
	 */
	@Override
	public void buld() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				putBeeper();
				move();
				turnLeft();
				move();
				turnRight();
			}
			turnRight();
		}
	}

}
