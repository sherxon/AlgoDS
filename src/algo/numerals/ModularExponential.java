/*
 * Modular exponentiation is a type of exponentiation performed over a modulus. It is useful in computer science, especially in the field of public-key cryptography.
 * Given three numbers x, y and p, compute (x^y) % p.
 * For every odd power, the result (which is initialized to 1) is updated as (result * base) % mod.
 * Then the power is divided by 2 and the base is updated to (base * base) % mod.
 * This is done till the power does not become 0.
 */

public class ModularExponential {

	private static int modularExponential(int base, int power, int mod) {

		int result = 1;
		base %= mod; 	// Update the base value if it is more than or equal to mod value

		while (power > 0) {
			if (power % 2 == 1)		// If power is odd, multiply update the result as below
				result = (result * base) % mod;
			power = power >> 1;		// power /= 2
			base = (base * base) % mod;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(modularExponential(25, 62, 19));
	}
}
