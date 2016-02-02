
package org.startupfactory.homework1.passgenerator;

/**
 * A class with method for generating a password
 * 
 * @author Rado
 *
 */
public class PasswordGenerator {
	/**
	 * Generate password and returns it as string
	 * 
	 * @param length
	 *            desired length of the password
	 * @return password generated string password
	 */
	public static String generate(int length) {
		String password = "";

		for (int i = 0; i < length; i++) {
			int smallLetters = (int) (Math.random() * 26 + 97);
			int bigLetters = (int) (Math.random() * 26 + 65);
			int numbers = (int) (Math.random() * 10 + 48);
			int whichRange = (int) (Math.random() * 3 + 1);
			int temp = 0;

			if (whichRange == 1) {
				temp = smallLetters;
			} else if (whichRange == 2) {
				temp = bigLetters;
			} else if (whichRange == 3) {
				temp = numbers;
			}

			char c = (char) temp;
			password = password + c;
		}

		return password;
	}

}
