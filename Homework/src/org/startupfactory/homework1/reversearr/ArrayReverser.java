package org.startupfactory.homework1.reversearr;

/**
 * A class with method for reversing array.
 * 
 * @author Rado
 *
 */
public class ArrayReverser {
	/**
	 * Reverse array of ints
	 * 
	 * @param array
	 *            of ints
	 */
	public static void reverse(int[] array) {

		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}

	}
}
