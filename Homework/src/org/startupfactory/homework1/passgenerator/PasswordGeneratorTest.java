/**
 * 
 */
package org.startupfactory.homework1.passgenerator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class that contains methods for testing the password generation.
 * 
 * @author Rado
 *
 */
public class PasswordGeneratorTest {
	private static final int LENGTH = 10;
	private String password = PasswordGenerator.generate(LENGTH);

	@Test
	public void testValidSymbols() {
		Assert.assertEquals(true, password.matches("[a-zA-Z0-9]+"));
	}

	@Test
	public void testGeneratedPasswordLength() {
		Assert.assertEquals(password.length(), LENGTH);
	}
}
