/*
 * A Combination is a selection of items from a collection, such that (unlike permutations) the order of selection does not matter.
 * Example : There are 6 combinations of two elements out of the set {1, 2, 3, 4} -> {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}.
 * Here, the order of selection does not matter.
 * The number of ways of picking k unordered outcomes from n possibilities is given by :
 * nCr = n! / r! * (n - r)!
 */

public class Combination {

	public static long ncr(int n, int r) {

		if (r > n || n < 0 || r < 0) // If r is greater than n or n or r is less than 0, then Combinations are not possible
			return -1;
		if (r > n / 2)		// If r is greater than half of n, then update r to n - r, because nCr = nC(n-r)
			r = n - r;
		long ans = 1;
		for (int i = 1; i <= r; i++) {
			ans *= n - r + i;
			ans /= i;
		}
		return ans;
	}

	public static void main(String[] args) {
		long combination = ncr(15, 5);
		if (combination > 0)
			System.out.println(combination);
		else
			System.out.println("Invalid Input");
	}
}
