package org.startupfactory.homework1.maxsubarrsum;

import org.junit.Assert;
import org.junit.Test;

public class TestMaxSubarrSum {

	@Test
	public void test() {
		int[] array = { 0, -1, 2, 3, 8, -10 };

		int actual = MaxSubarrSum.Calculate(array);
		int expected = 13;
		Assert.assertEquals(expected, actual);
	}

}
