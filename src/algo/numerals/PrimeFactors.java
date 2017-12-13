import java.util.ArrayList;

public class PrimeFactors {
	
	public static int[] primeFactors(int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();

		for (int i = 2; i <= Math.sqrt(num); i++) {
			while (num % i == 0) {
				factors.add(i);
				num /= i;
			}
		}
		if (num > 2)
			factors.add(num);
		int[] prime = new int[factors.size()];
		for (int i = 0; i < factors.size(); i++)
			prime[i] = factors.get(i);

		return prime;
	}

	public static void main(String[] args) {
		int[] factors = primeFactors(45);
		for (int i : factors)
			System.out.print(i + " ");
	}
}
