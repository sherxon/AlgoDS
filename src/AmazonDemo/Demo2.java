package AmazonDemo;

/**
 * Why Did you create this class? what does it do?
 */
public class Demo2 {
    public static void main(String[] args) {

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {
        // WRITE YOUR CODE HERE
        if (num <= 0 || arr == null || arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int gcdOfTwo = getGCD(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            gcdOfTwo = getGCD(gcdOfTwo, arr[i]);
        }
        return gcdOfTwo;

    }

    int getGCD(int x, int y) {
        if (y == 0)
            return x;
        return getGCD(y, x % y);
    }

    // METHOD SIGNATURE ENDS
}
