/*
 * LCM is the smallest positive integer that is divisible by both a and b.
 * Product of any two numbers is equal to the product of their LCM and GCD.
 * Hence, LCM will be the product of two numbers divided by their GCD. 
 */

public class LCM {

	public static int gcd(int num1, int num2) {
		if (num1 == 0)
			return num2;
		return gcd(num2 % num1, num1);
	}

	public static int lcm(int num1, int num2) {
		return (num1 * num2) / gcd(num1, num2);
	}

	public static void main(String[] args) {
		System.out.println(lcm(15, 20));
	}
}
