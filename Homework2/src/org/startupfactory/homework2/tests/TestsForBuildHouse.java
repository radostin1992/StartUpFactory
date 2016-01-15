package org.startupfactory.homework2.tests;

import org.junit.Test;
import org.startupfactory.homework2.buildhouse.MasionRobot;
import org.startupfactory.homework2.buildhouse.RightTurner;
import org.startupfactory.homework2.buildhouse.RoofBuilderRobot;
import org.startupfactory.homework2.buildhouse.WindowsAndDoor;

import kareltherobot.Directions;
import kareltherobot.KJRTest;
import kareltherobot.World;

public class TestsForBuildHouse extends KJRTest {

	public TestsForBuildHouse(String name) {
		super(name);
	}

	@Test
	/**
	 * Testing right turner robot, its final position and facing side.
	 */
	public void testRightTurnerRobot() {
		World.setSize(1, 1);
		World.setDelay(1);
		RightTurner robot = new RightTurner(1, 1, Directions.North, 1);
		robot.turnRight();
		assertAt(robot, 1, 1);
		assertFacingEast(robot);
	}

	@Test
	/**
	 * Testing masion builder robot its final position and facing side.
	 */
	public void testMasionBuilderRobot() {
		World.setSize(23, 23);
		World.setDelay(1);
		MasionRobot robot = new MasionRobot(1, 1, Directions.North, 100);
		robot.buld();
		assertAt(robot, 1, 1);
		assertFacingNorth(robot);
	}

	/**
	 * Testing roof builder robot its final position and facing side.
	 */
	@Test
	public void testRoofBuilderRobot() {
		World.setSize(23, 23);
		World.setDelay(1);
		RoofBuilderRobot robot = new RoofBuilderRobot(15, 1, Directions.East, 100);
		robot.buld();
		assertAt(robot, 15, 15);
		assertFacingWest(robot);
	}

	/**
	 * Testing windows and door builder robot its final position and facing
	 * side.
	 */
	@Test
	public void testWindowsAndDoorBuilderRobot() {
		World.setSize(23, 23);
		World.setDelay(1);
		WindowsAndDoor robot = new WindowsAndDoor(1, 1, Directions.North, 100);
		robot.buld();
		assertAt(robot, 1, 1);
		assertFacingNorth(robot);
	}

}
