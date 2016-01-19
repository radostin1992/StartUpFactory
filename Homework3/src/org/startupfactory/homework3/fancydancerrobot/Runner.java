/**
 * 
 */
package org.startupfactory.homework3.fancydancerrobot;

import kareltherobot.World;

/**
 * @author Rado
 *
 */
public class Runner {

	/**
	 * Program with robot which never stop moving and when he turns east it will
	 * be blinded by the sun;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		World.setDelay(10);
		World.setVisible();
		World.readWorld(System.getProperty("user.dir") + "\\libs\\labyrinth.kwld");
		FancyRobotManager.runRobot();
	}

}
