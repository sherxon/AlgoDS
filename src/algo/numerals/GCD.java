public class GCD {

	public static int gcd(int num1, int num2) {
		if (num1 == 0)
			return num2;
		return gcd(num2 % num1, num1);
	}

	public static void main(String[] args) {
		System.out.println(gcd(35, 10));
	}
}
