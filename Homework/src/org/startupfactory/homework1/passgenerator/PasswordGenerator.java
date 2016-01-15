/**
 * 
 */
package org.startupfactory.homework1.passgenerator;

/**
 * A class with method for generating a password
 * 
 * @author Rado
 *
 */
public class PasswordGenerator {
	/**
	 * 
	 * @param length
	 *            of the password
	 * @param whichRange
	 *            - 1 - symbols "a" to "z" 2 - symbols "A" to "Z" 3 - symbols
	 *            "0" to "9"
	 * @param temp
	 *            - random number from 97 to 127
	 * @param c
	 *            - convert temp to a character
	 * @return password - generated password
	 */
	public static String generate(int length) {
		String password = "";
		for (int i = 0; i < length; i++) {
			int whichRange = (int) (Math.random() * 3 + 1);
			int temp = 0;

			if (whichRange == 1) {
				temp = (int) (Math.random() * 26 + 97);
			} else if (whichRange == 2) {
				temp = (int) (Math.random() * 26 + 65);
			} else if (whichRange == 3) {
				temp = (int) (Math.random() * 10 + 48);
			}

			char c = (char) temp;
			password = password + c;
		}

		return password;
	}

}
