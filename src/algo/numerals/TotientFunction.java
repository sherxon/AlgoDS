/*
 * Euler's Totient Funtion for an input 'n' is the count of numbers in {1, 2, 3, ..., n} that are
 * relatively prime to n, i.e., the numbers whose GCD with n is 1.
 * The idea is based on Euler’s product formula which states that value of totient functions is below product over all prime factors p of n.
 * The formula basically says that the value of Φ(n) is equal to n multiplied by product of (1 – 1/p) for all prime factors p of n.
 */

public class TotientFunction {

	private static int phi(int n) {
		float result = n;		// Initializing result as n

		for (int i = 2; i * i <= n; i++) {
			// Checking whether i is the prime factor of n
			if (n % i == 0) {
				// If i is the prime factor of n, divide n by i till i is the its prime factor
				while (n % i == 0)
					n /= i;
				// Update result with the Euler's product formula (1 - 1/p)
				result *= (1.0 - (1.0 / (float)i));
			}
		}
		// If n has a prime factor greater than sqrt(n), then update the result
		// Note that there can be at-most one such prime factor
		if (n > 1)
			result *= (1.0 - (1.0 / (float)n));
		return (int)result;
	}

	public static void main(String[] args) {
		System.out.println("The count of numbers that are relatively prime to 8 are " + phi(8));
	}
}
