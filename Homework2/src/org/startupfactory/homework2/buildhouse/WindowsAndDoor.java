/**
 * 
 */
package org.startupfactory.homework2.buildhouse;

/**
 * Robot which buids the windows and the door of the house;
 * 
 * @author Rado
 *
 */
public class WindowsAndDoor extends RightTurner implements HouseBuilder {

	public WindowsAndDoor(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

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
