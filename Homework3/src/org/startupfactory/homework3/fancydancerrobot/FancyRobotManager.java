/**
 * 
 */
package org.startupfactory.homework3.fancydancerrobot;

/**
 * Manage robot movements;
 * 
 * @author Rado
 *
 */
public class FancyRobotManager {
	static FancyRobot robot;

	public static void runRobot() {
		robot = new FancyRobot(6, 2);
		robot.setVisible(true);
		while (true) {
			try {
				robot.carefulMove();
			} catch (FoundWallException | EastExceptions e) {
				e.printStackTrace();
			} finally {
				dontStop();
			}
		}
	}

	static void dontStop() {
		int random = (int) Math.floor(Math.random() * (3 - 0)) + 0;
		if (random == 0) {
			robot.turnLeft();
		} else if ((random == 1)) {
			robot.turnLeft();
			robot.turnLeft();
		} else if (random == 2) {
			robot.turnLeft();
			robot.turnLeft();
			robot.turnLeft();
		}
	}

}
