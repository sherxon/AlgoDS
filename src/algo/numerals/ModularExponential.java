public class ModularExponential {

	private static int modularExponential(int base, int power, int mod) {

		int result = 1;
		base %= mod;

		while (power > 0) {
			if (power % 2 == 1)
				result = (result * base) % mod;
			power = power >> 1;
			base = (base * base) % mod;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(modularExponential(25, 62, 19));
	}
}
