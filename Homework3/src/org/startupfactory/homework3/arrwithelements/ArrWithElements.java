/**
 * 
 */
package org.startupfactory.homework3.arrwithelements;

/**
 * Program for adding, removing and printing array with limited size;
 * 
 * @author Rado
 *
 */
public class ArrWithElements {
	int[] ARR = new int[5];
	int i = 0;

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * Add parameter num to the array if it's not full;
	 * 
	 * @param num
	 *            is the number we want to add;
	 * @throws FullArrException
	 *             if the array is full;
	 */
	public void add(int num) throws FullArrException {
		if (i < 4) {
			ARR[i] = num;
			i++;
		} else {
			System.out.println("Array is full!");
			throw new FullArrException("Array is full!");
		}

	}

	/**
	 * Removes last element of the array.
	 * 
	 * @throws EmptyListException
	 *             if the array is empty;
	 */
	public void remove() throws EmptyListException {
		if (i > 0) {
			ARR[i - 1] = 0;
			i--;
		} else {
			System.out.println("Array is empty - nothing to remove!");
			throw new EmptyListException("Array is empty - nothing to remove!");
		}

	}

	/**
	 * Prints all elements of the array;
	 */
	public void printAllElements() {
		for (int j = 0; j < i; j++) {
			System.out.println(ARR[j]);
		}
	}

}
