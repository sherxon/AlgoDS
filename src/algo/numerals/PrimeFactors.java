/*
 * The prime factors of a positive integer are the prime numbers that divide that integer exactly.
 * Example : 			     864
 						 /		   \
					    32		    27
					 /     \      /    \
				    4		8    3	    9
				   / \    / | \  |    /   \
				  2   2  2  2  2 3   3     3
 * Here, 864 can be written as 2 x 2 x 2 x 2 x 2 x 3 x 3 x 3. These are the prime factors of 864.
 */

import java.util.ArrayList;

public class PrimeFactors {
	
	public static int[] primeFactors(int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();	// Creating an ArrayList to store the prime factors

		for (int i = 2; i <= Math.sqrt(num); i++) {
			while (num % i == 0) {		// If i divides the number with remainder 0,
				factors.add(i);			// add i to the list and
				num /= i;				// divide the number with i until i divides the number with remainder 0
			}
		}
		if (num > 2)
			factors.add(num);			// If the remaining number is greater than 2 then that must be a prime number, so add that in the list
		int[] prime = new int[factors.size()];
		for (int i = 0; i < factors.size(); i++) // Converting ArrayList into Array
			prime[i] = factors.get(i);

		return prime;
	}

	public static void main(String[] args) {
		int[] factors = primeFactors(45);
		for (int i : factors)
			System.out.print(i + " ");
	}
}
