public class BabylonianSquareRoot {

	private static float babylonianSquareRoot(float num) throws ArithmeticException {
		
		if (num < 0)
			throw new ArithmeticException("NaN");
		float x = num;
		float y = 1; 
		float e = 0.00000001f;

		while (x - y > e) {
			x = (x + y) / 2;
			y = num / x;
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println(babylonianSquareRoot(52));	
	}
}
