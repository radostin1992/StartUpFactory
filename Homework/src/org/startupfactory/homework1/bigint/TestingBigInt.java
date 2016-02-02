/**
 * 
 */
package org.startupfactory.homework1.bigint;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rado
 *
 */
public class TestingBigInt {

	@Test
	public void testSumOfTwoSimpleNumbers() {
		String firstNumber = "2";
		String secondNumber = "2";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "4";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSumOfTwoNumbers() {
		String firstNumber = "22";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "44";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSumOfTwoNumbersWithDiffrentLength() {
		String firstNumber = "2";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "24";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSumOfTwoNumbersWhenTwoNumsAreEqualToTen() {
		String firstNumber = "28";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "50";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSumOfTwoNumbersWhenTwoNumsAreBiggerThanTen() {
		String firstNumber = "29";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "51";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSumOfTwoBigNumbers() {
		// 2147483647
		String firstNumber = "454354654653";
		String secondNumber = "656536436436436";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "656990791091089";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testsSumWhenWeDidntClearInMindInFor() {
		String firstNumber = "99";
		String secondNumber = "1";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "100";
		Assert.assertEquals(expected, actual);
	}
}
