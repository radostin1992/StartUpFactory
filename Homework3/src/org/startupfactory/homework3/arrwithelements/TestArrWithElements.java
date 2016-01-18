/**
 * 
 */
package org.startupfactory.homework3.arrwithelements;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rado
 *
 */
public class TestArrWithElements {
	/**
	 * Test adding element to the array;
	 * 
	 * @throws FullArrException
	 */
	@Test
	public void testAddingElement() throws FullArrException {
		ArrWithElements element = new ArrWithElements();
		element.add(2);
		int actual = element.getI();
		int expected = 1;
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test removing element from the array;
	 * 
	 * @throws NullArrException
	 * @throws FullArrException
	 */
	@Test
	public void testRemovingElement() throws NullArrException, FullArrException {
		ArrWithElements element = new ArrWithElements();
		element.add(2);
		element.add(5);
		element.remove();
		int actual = element.getI();
		int expected = 1;
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test adding element to the array when it is full;
	 * 
	 * @throws FullArrException
	 */
	@Test(expected = FullArrException.class)
	public void testAddingElementsToFullArr() throws FullArrException {
		ArrWithElements element = new ArrWithElements();
		element.add(2);
		element.add(5);
		element.add(5);
		element.add(5);
		element.add(5);
		element.add(5);
	}

	/**
	 * Test removing element from the array when it is empty;
	 * 
	 * @throws NullArrException
	 */
	@Test(expected = NullArrException.class)
	public void testRemovingElementsToEmptyArr() throws NullArrException {
		ArrWithElements element = new ArrWithElements();
		element.remove();
	}

}
