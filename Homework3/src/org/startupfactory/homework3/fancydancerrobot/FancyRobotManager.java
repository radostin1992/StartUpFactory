package org.startupfactory.homework3.fancydancerrobot;

/**
 * Manage robot movements;
 * 
 * @author Rado
 *
 */
public class FancyRobotManager {
	private static FancyRobot ROBOT;

	/**
	 * Runs the robot
	 */
	public static void runRobot() {
		ROBOT = new FancyRobot(6, 2);
		ROBOT.setVisible(true);
		while (true) {
			try {
				ROBOT.carefulMove();
			} catch (FoundWallException | EastExceptions e) {
				e.printStackTrace();
			} finally {
				dontStop();
			}
		}
	}

	/**
	 * Makes decision about the direction
	 */
	static void dontStop() {
		int random = (int) Math.floor(Math.random() * (3 - 0)) + 0;
		if (random == 0) {
			ROBOT.turnLeft();
		} else if ((random == 1)) {
			ROBOT.turnLeft();
			ROBOT.turnLeft();
		} else if (random == 2) {
			ROBOT.turnLeft();
			ROBOT.turnLeft();
			ROBOT.turnLeft();
		}
	}

	/**
	 * @return the rOBOT
	 */
	public static FancyRobot getROBOT() {
		return ROBOT;
	}

	/**
	 * @param rOBOT
	 *            the rOBOT to set
	 */
	public static void setROBOT(FancyRobot rOBOT) {
		ROBOT = rOBOT;
	}
}
