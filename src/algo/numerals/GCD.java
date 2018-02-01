/*
 * The greatest common divisor is the largest natural number that divides two numbers without leaving a remainder.
 */

public class GCD {

	public static int gcd(int num1, int num2) {
		if (num1 == 0)			// If the first number becomes 0, then the second number is the GCD of the two numbers.
			return num2;
		return gcd(num2 % num1, num1);	// Else, find the GCD of the remainder when second number is divided by the first, and the first number.
	}

	public static void main(String[] args) {
		System.out.println(gcd(35, 10));
	}
}
