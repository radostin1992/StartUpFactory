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
	/*
	 * Test summing of two simple numbers;
	 */
	public void testSumOfTwoSimpleNumbers() {
		String firstNumber = "2";
		String secondNumber = "2";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "4";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/*
	 * Test summing two digit numbers;
	 */
	public void testSumOfTwoNumbers() {
		String firstNumber = "22";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "44";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	/*
	 * Test summing two numbers with different length;
	 */
	@Test
	public void testSumOfTwoNumbersWithDiffrentLength() {
		String firstNumber = "2";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "24";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/*
	 * Test summing two numbers when we have zero in mind;
	 */
	public void testSumOfTwoNumbersWhenTwoNumsAreEqualToTen() {
		String firstNumber = "28";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "50";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/*
	 * Test summing two numbers when we have in mind;
	 */
	public void testSumOfTwoNumbersWhenTwoNumsAreBiggerThanTen() {
		String firstNumber = "29";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "51";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/*
	 * Test summing two bigint numbers;
	 */
	public void testSumOfTwoBigNumbers() {
		String firstNumber = "454354654653";
		String secondNumber = "656536436436436";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "656990791091089";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}
}
