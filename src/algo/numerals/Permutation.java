public class Permutation {

	public static long npr(int n, int r) {

		if (r > n || n < 0 || r < 0)
			return -1;
		long ans = 1;
		for (int i = n; i > n - r; i--)
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