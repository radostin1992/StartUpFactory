/**
 * 
 */
package org.startupfactory.homework1.maxsubarrsum;

/**
 * @author Rado
 *
 */
public class MaxSubarrSum {

	public static int Calculate(int[] array) {
		int maxSoFar = 0;
		int maxEndingHere = 0;

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
