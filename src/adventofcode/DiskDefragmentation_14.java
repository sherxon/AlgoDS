package adventofcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Why Did you create this class? what does it do?
 */
public class DiskDefragmentation_14 {
    public static void main(String[] args) {
        // System.out.println(solve("nbysizxe"));
        System.out.println(solve2("nbysizxe"));
    }

    private static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < 128; i++) {
            String row = s + "-" + i;
            String hash = KnotHash_10.calculateKnotHash(row);
            for (int j = 0; j < hash.length(); j++) {
                count += hexBitCount(String.valueOf(hash.charAt(j)));
            }
        }

        return count;
    }

    private static int solve2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        int[][] a = new int[128][128];
        for (int i = 0; i < 128; i++) {
            String row = s + "-" + i;
            String hash = KnotHash_10.calculateKnotHash(row);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < hash.length(); j++) {
                String bin = hexToBin(String.valueOf(hash.charAt(j)));
                builder.append(bin);
            }
            for (int k = 0; k < builder.length(); k++) {
                a[i][k] = builder.charAt(k) - '0';
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    removeRegion(a, i, j);
                }
            }
        }

        return count;
    }

    private static void removeRegion(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a.length)
            return;
        if (a[i][j] == 0)
            return;
        a[i][j] = 0;
        removeRegion(a, i + 1, j);
        removeRegion(a, i - 1, j);
        removeRegion(a, i, j + 1);
        removeRegion(a, i, j - 1);
    }

    static int hexBitCount(String s) {
        return new BigInteger(s, 16).bitCount();
    }

    static String hexToBin(String s) {
        StringBuilder ss = new StringBuilder(new BigInteger(s, 16).toString(2));
        for (int i = ss.length(); i < 4; i++) {
            ss.insert(0, "0");
        }
        return ss.toString();
    }
}
