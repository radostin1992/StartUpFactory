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
	// TODO: why are those member variables? Is it needed for them to be outside
	// of the sum method?
	int firstNum = 0;
	int secondNum = 0;
	int result = 0;
	int remainder = 0;

	/**
	 * TODO: missing comment, also the param comments are not correct.
	 * 
	 * @param a
	 *            - first number which will be devided;
	 * @param b
	 *            - second number which will devide;
	 * @return
	 * @throws Exception
	 *             IllegalArgumentException if second number is zero;
	 */
	public void division(int a, int b) throws Exception {
		firstNum = a;
		secondNum = b;

		String resStr = null;

		try {
			if (secondNum == 0) {
				System.out.println("Division by zero is not allowed!");
				throw new IllegalArgumentException(
						"Division by zero is not allowed!");

			}
			if (secondNum != 0) {
				result = firstNum / secondNum;
				remainder = firstNum - (result * secondNum);
				resStr = firstNum + "/" + secondNum + "=" + result
						+ " with remainder:" + remainder;
				System.out.println(resStr);
			}

		} finally {
			System.out.println("GoodBye!");
		}
	}

	public int getResult() {
		return result;
	}

	public int getRemainder() {
		return remainder;
	}
}
