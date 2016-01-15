/**
 * 
 */
package org.startupfactory.homework1.reversearr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rado
 *
 */
public class ReverseArrayTest {
	/**
	 * Tests the simple case when reversing array with integers.
	 */
	@Test
	public void testSimpleCase() {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] expected = { 5, 4, 3, 2, 1 };

		ArrayReverser.reverse(array);
		Assert.assertArrayEquals(expected, array);
	}

	/**
	 * Tests when the method is given null as input argument.
	 */
	@Test(expected = NullPointerException.class)
	public void testNullArray() {
		int[] input = null;
		ArrayReverser.reverse(input);
	}

}
