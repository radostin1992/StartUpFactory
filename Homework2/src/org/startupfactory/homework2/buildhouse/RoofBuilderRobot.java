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

	public RoofBuilderRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

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
