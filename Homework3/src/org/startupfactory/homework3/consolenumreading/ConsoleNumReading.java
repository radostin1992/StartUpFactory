/**
 * 
 */
package org.startupfactory.homework3.consolenumreading;

import java.util.Scanner;

/**
 * @author Rado
 *
 */
public class ConsoleNumReading {

	public static void read() throws OutsideBoundsException,
			UnderBoundsException {
		Scanner sc = null;
		int buffer = 0;
		try {
			sc = new Scanner(System.in);

			while (sc.hasNext()) {
				buffer = sc.nextInt();

				if (buffer > 100) {
					// TODO: why not just pass the message to the exception
					// instead of printing it? :)
					System.out
							.println("The number you entered is bigger than one hundred!");
					throw new OutsideBoundsException(
							"The number you entered is bigger than one hundred!");
				}
				if (buffer < 0) {
					// TODO: why not just pass the message to the exception
					// instead of printing it? :)
					System.out
							.println("The number you entered is smaller than zero!");
					throw new UnderBoundsException();
				} else {
					System.out.println(" Your number: " + buffer);
				}
			}
		} finally {
			sc.close();
		}
	}
}
