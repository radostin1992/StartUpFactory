/**
 * 
 */
package org.startupfactory.homework2.buildhouse;

/**
 * Robot which builds the windows and the door of the house;
 * 
 * @author Rado
 *
 */
public class WindowsAndDoor extends RightTurner implements HouseBuilder {
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
	public WindowsAndDoor(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	/**
	 * Method which helps building the windwos and door of the house
	 */
	@Override
	public void buld() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				putBeeper();
				move();

			}
			turnRight();
		}
	}

}
