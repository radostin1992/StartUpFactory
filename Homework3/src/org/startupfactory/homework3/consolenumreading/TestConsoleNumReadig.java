/**
 * 
 */
package org.startupfactory.homework3.consolenumreading;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

/**
 * @author Rado
 *
 */
public class TestConsoleNumReadig {

	@Test
	public void testConsoleNumReadingWithinBounds() throws OutsideBoundsException, UnderBoundsException {
		String input = "10";
		ByteArrayInputStream inputMock = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

		System.setIn(inputMock);
		ConsoleNumReading.read();
	}

	@Test(expected = OutsideBoundsException.class)
	public void testConsoleNumReadingOutsideBounds() throws OutsideBoundsException, UnderBoundsException {
		String input = "101";
		ByteArrayInputStream inputMock = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

		System.setIn(inputMock);
		ConsoleNumReading.read();
	}

	@Test(expected = UnderBoundsException.class)
	public void testConsoleNumReadingUnderBounds() throws OutsideBoundsException, UnderBoundsException {
		String input = "-1";
		ByteArrayInputStream inputMock = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

		System.setIn(inputMock);
		ConsoleNumReading.read();
	}
}
