package algo.numerals;
/*
 * Babylonian Sqaure Root is a method to find Square Root of a number by simple mathematical operations.
 * The steps involved in calculating the square root are :
 * 1) Start with an arbitrary positive start value x (the closer to the root, the better).
 * 2) Initialize y = 1.
 * 3) Do following until desired approximation is achieved.
 *		a) Get the next approximation for root using average of x and y
 *		b) Set y = n/x
 */

public class BabylonianSquareRoot {

    private static float babylonianSquareRoot(float num) throws ArithmeticException {

        if (num < 0)
            throw new ArithmeticException("NaN");
        float x = num;
        float y = 1;
        float e = 0.00000001f;    // e decides the accuracy level. Smaller the value of e, more is the answer accurate, but also more are the steps involved

        // Looping while the difference between x and y is greater than e
        while (x - y > e) {
            x = (x + y) / 2;    // Updating x with the average of x and y
            y = num / x;        // Updating y with original number divided by the average
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(babylonianSquareRoot(52));
    }
}
