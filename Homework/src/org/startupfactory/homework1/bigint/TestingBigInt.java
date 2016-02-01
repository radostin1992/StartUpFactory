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

	
	/* TODO: this is not javadoc
	 * Test summing of two simple numbers;
	 */
	@Test
	public void testSumOfTwoSimpleNumbers() {
		String firstNumber = "2";
		String secondNumber = "2";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "4";
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	
	/* TODO: this is not javadoc
	 * Test summing two digit numbers;
	 */
	@Test
	public void testSumOfTwoNumbers() {
		String firstNumber = "22";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "44";
		// TODO: No need for sysout
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	/*
	 * TODO: this is not javadoc
	 * Test summing two numbers with different length;
	 */
	@Test
	public void testSumOfTwoNumbersWithDiffrentLength() {
		String firstNumber = "2";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "24";
		// TODO: No need for sysout
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	
	/*
	 * TODO: this is not javadoc
	 * Test summing two numbers when we have zero in mind;
	 */
	@Test
	public void testSumOfTwoNumbersWhenTwoNumsAreEqualToTen() {
		String firstNumber = "28";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "50";
		// TODO: No need for sysout
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	
	/*
	 * Test summing two numbers when we have in mind;
	 */
	@Test
	public void testSumOfTwoNumbersWhenTwoNumsAreBiggerThanTen() {
		String firstNumber = "29";
		String secondNumber = "22";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "51";
		// TODO: No need for sysout
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}

	
	/*
	 * TODO: this is not javadoc
	 * Test summing two bigint numbers;
	 */
	@Test
	public void testSumOfTwoBigNumbers() {
		String firstNumber = "454354654653";
		String secondNumber = "656536436436436";

		String actual = SumBigInt.calculate(firstNumber, secondNumber);
		String expected = "656990791091089";
		// TODO: No need for sysout
		System.out.println("result:" + actual);
		Assert.assertEquals(expected, actual);
	}
}
