/*
 * A permutation is a rearrangement of the elements of an ordered list into a one-to-one correspondence with itself.
 * Example : Permutations of (1, 2, 3) will be (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), and (3,2,1).
 * The number of ways of obtaining an ordered subset of k elements from a set of n elements is given by :
 * nPr = n! / (n - r)!
 */

public class Permutation {

	public static long npr(int n, int r) {

		if (r > n || n < 0 || r < 0) 		// If r is greater than n or n or r is less than 0, then the permutations are not possible
			return -1;
		long ans = 1;
		for (int i = n; i > n - r; i--) 	// Loop to find product of numbers from n to n - r as 1 to r-1 numbers are cancelled in the formula of nPr
			ans *= i;
		return ans;
	}

	public static void main(String[] args) {
		long permutation = npr(15, 5);
		if (permutation > 0)
			System.out.println(permutation);
		else
			System.out.println("Invalid Input");
	}
}
