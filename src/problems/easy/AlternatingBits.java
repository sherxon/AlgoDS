package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class AlternatingBits {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(10));
    }

    static boolean hasAlternatingBits(int n) {
        Boolean x = null;
        int m = 0;
        for (int i = 0; i < 32; i++) {
            int k = ((n >> i) & 1);
            if (k == 1)
                m = m | (1 << i);
            if (x == null) {
                x = k == 1;
                continue;
            }
            if (x == (k == 1))
                return false;
            if (m == n)
                return true;

            x = !x;
        }
        return true;
    }
}
