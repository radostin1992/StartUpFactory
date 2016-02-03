/**
 * 
 */
package org.startupfactory.homework3.division;

/**
 * Program for division with remainder.
 * 
 * @author Rado
 *
 */
public class DivisionTwoNumbers {
	private static int RESULT = 0;
	private static int REMAINDER = 0;

	/**
	 * Devides two integer numbers
	 * 
	 * @param a
	 *            - first number which will be devided;
	 * @param b
	 *            - second number which will devide;
	 * @throws IllegalArgumentException
	 *             if second number is zero;
	 */
	public void division(int a, int b) throws Exception {
		int firstNum = a;
		int secondNum = b;

		String resStr = null;

		try {
			if (secondNum == 0) {
				System.out.println("Division by zero is not allowed!");
				throw new IllegalArgumentException("Division by zero is not allowed!");

			}
			if (secondNum != 0) {
				RESULT = firstNum / secondNum;
				REMAINDER = firstNum - (RESULT * secondNum);
				resStr = firstNum + "/" + secondNum + "=" + RESULT + " with remainder:" + REMAINDER;
				System.out.println(resStr);
			}

		} finally {
			System.out.println("GoodBye!");
		}
	}

	public int getResult() {
		return RESULT;
	}

	public int getRemainder() {
		return REMAINDER;
	}
}
