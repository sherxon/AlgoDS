package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class RotatedDigits {
    public int rotatedDigits(int n) {
        if (n <= 1)
            return 0;
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (!check(i)) {
                counter++;

            }
        }
        return counter;
    }

    boolean check(int k) {
        int m = 0;
        int n = 0;
        while (k > 0) {
            n *= 10;
            m *= 10;
            if (k % 10 == 2) {
                n += 5;
            } else if (k % 10 == 5) {
                n += 2;
            } else if (k % 10 == 6) {
                n += 9;
            } else if (k % 10 == 9) {
                n += 6;
            } else if (k % 10 == 1 || k % 10 == 8 || k % 10 == 0) {
                n += k % 10;
            } else {
                return true;
            }
            m += k % 10;
            k /= 10;
        }
        return m == n;
    }
}
