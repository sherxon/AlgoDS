public class Factorial {

	private static long factorial(int num) {
		if (num <= 1)
			return 1;
		return num * factorial(num - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(10));	
	}
}
