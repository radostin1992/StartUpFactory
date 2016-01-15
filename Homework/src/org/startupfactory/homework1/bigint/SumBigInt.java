/**
 * 
 */
package org.startupfactory.homework1.bigint;

/**
 * @author Rado Program sum two numbers with human method. It get numbers as
 *         strings, so it can calculate very big numbers.
 */
public class SumBigInt {
	/**
	 * 
	 * @param firstNumber
	 *            is the first number;
	 * @param secondNumber
	 *            is the second number;
	 * @param fNum
	 *            is the local variable of the first number;
	 * @param sNum
	 *            is the local variable of the second number;
	 * @param inMind
	 *            is variable which helps to "save in mind";
	 * @param lastIndex
	 *            is variable which helps to get last digit of string number;
	 * @param fNumLastDigit
	 *            is the last char digit of first string number;
	 * @param sNumLastDigit
	 *            is the last char digit of second string number;
	 * @param fNumLastDigitInt
	 *            is the converted to integer fNumLastDigit;
	 * @param fNumLastDigitInt
	 *            is the converted to integer sNumLastDigit;
	 * @param tempSum
	 *            is temporary sum of two last digit of the numbers;
	 * @return sum is calculated answer of the two numbers;
	 */
	public static String calculate(String firstNumber, String secondNumber) {
		String fNum = firstNumber;
		String sNum = secondNumber;

		String sum = "";
		if (fNum.length() < sNum.length()) {
			for (int i = fNum.length(); i < sNum.length(); i++) {
				fNum = "0" + fNum;
			}
		} else if (sNum.length() < fNum.length()) {
			for (int i = sNum.length(); i < fNum.length(); i++) {
				sNum = "0" + sNum;
			}
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
			if (tempSum > 9 || tempSum == 10) {
				inMind = 1;
				tempSum = tempSum - 10;
			}
			sum = tempSum + sum;
		}
		return sum;
	}

}
