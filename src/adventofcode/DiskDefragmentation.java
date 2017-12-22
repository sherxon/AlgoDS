package adventofcode;

import java.math.BigInteger;

/**
 * Why Did you create this class? what does it do?
 */
public class DiskDefragmentation {
    public static void main(String[] args) {
        System.out.println(solve("flqrgnkx"));
    }

    private static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        System.out.println(hexToBin(s.toUpperCase()));

        return count;
    }

    static String hexToBin(String s) {
        return new BigInteger(s, 16).toString(2);
    }
}
