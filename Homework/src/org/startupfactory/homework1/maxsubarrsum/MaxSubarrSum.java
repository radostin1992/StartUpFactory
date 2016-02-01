/**
 * 
 */
package org.startupfactory.homework1.maxsubarrsum;

/**
 * TODO: missing comment
 * 
 * @author Rado
 *
 */
public class MaxSubarrSum {

	/**
	 * TODO: missing comment
	 */
	public static int Calculate(int[] array) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		// TODO: are you sure this works correctly?
		for (int i = 0; i < array.length; i++) {
			maxEndingHere = maxEndingHere + array[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}

}
