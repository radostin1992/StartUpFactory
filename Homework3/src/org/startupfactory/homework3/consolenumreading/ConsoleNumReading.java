/**
 * 
 */
package org.startupfactory.homework3.consolenumreading;

import java.util.Scanner;

/**
 * Reads the number you enter and check is it in bounds ( 0 - 100 )
 * 
 * @author Rado
 *
 */
public class ConsoleNumReading {
	/**
	 * Reads the number entered by console
	 * 
	 * @throws OutsideBoundsException
	 *             when the number is bigger than 100
	 * @throws UnderBoundsException
	 *             when the number is smaller than 0
	 */
	public static void read() throws OutsideBoundsException, UnderBoundsException {
		Scanner sc = null;
		int buffer = 0;
		try {
			sc = new Scanner(System.in);

			while (sc.hasNext()) {
				buffer = sc.nextInt();

				if (buffer > 100) {
					throw new OutsideBoundsException("The number you entered is bigger than one hundred!");
				}
				if (buffer < 0) {
					throw new UnderBoundsException("The number you entered is smaller than zero!");
				} else {
					System.out.println(" Your number is in the range: " + buffer);
				}
			}
		} finally {
			sc.close();
		}
	}
}
