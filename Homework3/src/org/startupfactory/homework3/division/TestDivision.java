package org.startupfactory.homework3.division;

import org.junit.Assert;
import org.junit.Test;

public class TestDivision {
	public static final DivisionTwoNumbers DIV = new DivisionTwoNumbers();

	/**
	 * Test for throwing exception when second number is zero.
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNPE() throws Exception {
		int a = 13;
		int b = 0;

		DIV.division(a, b);
	}

	/**
	 * Testing result from the division;
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDivisionResult() throws Exception {
		int a = 13;
		int b = 10;

		DIV.division(a, b);
		int actualResult = DIV.getResult();
		int expectedResult = 1;
		Assert.assertEquals(expectedResult, actualResult);
	}

	/**
	 * Test the remainder from the division;
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDivisionRemainder() throws Exception {
		int a = 13;
		int b = 10;

		DIV.division(a, b);
		int actualRemainder = DIV.getRemainder();
		int expectedRemainder = 3;
		Assert.assertEquals(expectedRemainder, actualRemainder);
	}
}
