/**
 * 
 */
package org.startupfactory.homework2.buildhouse;

import kareltherobot.Directions;
import kareltherobot.World;

/**
 * Program which build house with karel the robot.
 * 
 * @author Rado
 *
 */
public class Runner {

	public static void main(String[] args) {
		World.setSize(23, 23);
		World.setDelay(1);
		World.setVisible(true);

		MasionRobot masionBuild = new MasionRobot(1, 1, Directions.North, 100);
		masionBuild.buld();

		RoofBuilderRobot roofBuild = new RoofBuilderRobot(15, 1, Directions.East, 100);
		roofBuild.buld();

		WindowsAndDoor doorBuild = new WindowsAndDoor(1, 1, Directions.North, 100);
		doorBuild.buld();

		WindowsAndDoor firstWindow = new WindowsAndDoor(9, 3, Directions.North, 100);
		firstWindow.buld();

		WindowsAndDoor secondWindow = new WindowsAndDoor(9, 9, Directions.North, 100);
		secondWindow.buld();
	}

}
