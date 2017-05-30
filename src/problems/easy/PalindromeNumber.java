package problems.easy;

/**
 * Created by sherxon on 1/11/17.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        int xx = x;
        int m = x % 10;
        xx /= 10;
        while (xx != 0) {
            int rem = xx % 10;
            xx /= 10;
            m *= 10;
            m += rem;
        }
        return m == x;
    }
}
