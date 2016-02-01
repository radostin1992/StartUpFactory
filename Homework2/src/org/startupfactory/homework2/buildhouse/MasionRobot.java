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
	 * TODO: comments
	 */
	public MasionRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

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
