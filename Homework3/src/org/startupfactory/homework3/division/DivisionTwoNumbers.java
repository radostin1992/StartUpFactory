/**
 * 
 */
package org.startupfactory.homework3.division;

/**
 * @author Rado
 *
 */
public class DivisionTwoNumbers {

	public void division(int a, int b) throws Exception {
		int firstNum = a;
		int secondNum = b;
		int result = 0;
		int remainder = 0;

		try {
			if (secondNum == 0) {
				throw new IllegalArgumentException("Division by zero is not allowed!");
			}
			if (secondNum != 0) {
				result = firstNum / secondNum;
				remainder = firstNum - (result * secondNum);
				String resStr = firstNum + "/" + secondNum + "=" + result + " with remainder:" + remainder;
				System.out.println(resStr);
			}

		} finally {
			System.out.println("GoodBye!");
		}

	}
}
