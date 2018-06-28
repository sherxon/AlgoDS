package AmazonDemo;

/**
 * Why Did you create this class? what does it do?
 * Given an innnite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
public class Coin {
    static int count = 0;

    public static void main(String[] args) {
        int[] a = new int[] { 5, 10, 25 };
        go(a, 0, 20);
        System.out.println(count);
    }

    private static void go(int[] a, int k, int n) {
        if (n < 0 || k >= a.length)
            return;
        if (n == 0) {
            count++;
        }
        for (int i = k; i < a.length; i++) {
            go(a, i, n - a[i]);
        }
    }

}
