package org.startupfactory.homework3.division;

import org.junit.Test;

public class TestDivision {

	@Test(expected = IllegalArgumentException.class)
	public void testNPE() throws Exception {
		int a = 13;
		int b = 0;
		DivisionTwoNumbers div = new DivisionTwoNumbers();

		div.division(a, b);

	}

}
