public class TotientFunction {

	private static int phi(int n) {
		float result = n;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				result *= (1.0 - (1.0 / (float)i));
			}
		}

		if (n > 1)
			result *= (1.0 - (1.0 / (float)n));
		return (int)result;
	}

	public static void main(String[] args) {
		System.out.println("The count of numbers that are relatively prime to 8 are " + phi(8));
	}
}
