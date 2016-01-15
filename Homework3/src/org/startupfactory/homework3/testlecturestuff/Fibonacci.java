package org.startupfactory.homework3.testlecturestuff;

/**
 * Testing fibonacci with recursion
 * 
 * @author Rado
 *
 */
public class Fibonacci {

	public static int fibonacci(int n) {
		if (n <= 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(20));
	}

}
