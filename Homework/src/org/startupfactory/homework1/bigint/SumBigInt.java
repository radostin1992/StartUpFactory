/**
 * Program sum two numbers with human method. It get numbers as
 *         strings, so it can calculate very big numbers.
 */
package org.startupfactory.homework1.bigint;

/**
 * 
 * @author Rado
 */

public class SumBigInt {

	/**
	 * Sums two large numbers as String
	 * 
	 * @param firstNumber
	 *            is the first number;
	 * @param secondNumber
	 *            is the second number;
	 */
	public static String calculate(String firstNumber, String secondNumber) {
		String fNum = firstNumber;
		String sNum = secondNumber;
		StringBuilder sb = new StringBuilder();

		String sum = "";
		if (fNum.length() < sNum.length()) {
			for (int i = fNum.length(); i < sNum.length(); i++) {
				sb.append("0");
			}
			sb.append(fNum);
			fNum = sb.toString();

		} else if (sNum.length() < fNum.length()) {
			for (int i = sNum.length(); i < fNum.length(); i++) {
				sb.append("0");
			}
			sb.append(sNum);
			sNum = sb.toString();
		}
		int inMind = 0;
		int lastIndex = 1;
		for (int i = fNum.length(); i > 0; i--) {
			char fNumLastDigit = fNum.charAt(fNum.length() - lastIndex);
			char sNumLastDigit = sNum.charAt(sNum.length() - lastIndex);
			lastIndex++;
			int fNumLastDigitInt = Character.getNumericValue(fNumLastDigit);
			int sNumLastDigitInt = Character.getNumericValue(sNumLastDigit);

			int tempSum = fNumLastDigitInt + sNumLastDigitInt;
			if (inMind == 1) {
				tempSum = tempSum + inMind;
				inMind = inMind - 1;
			}
			if (tempSum > 9) {
				inMind = 1;
				tempSum = tempSum - 10;
			}
			sum = tempSum + sum;
		}
		if (inMind > 0) {
			sum = 1 + sum;
		}
		return sum;
	}

}
