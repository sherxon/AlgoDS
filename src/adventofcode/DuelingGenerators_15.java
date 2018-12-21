package adventofcode;

import java.math.BigInteger;

/**
 * http://adventofcode.com/2017/day/15
 */
public class DuelingGenerators_15 {
    public static void main(String[] args) {
        // System.out.println(solve(65, 8921));
        System.out.println(solve(516, 190));
    }

    private static int solve(int first, int second) {
        BigInteger f = new BigInteger(String.valueOf(first));
        BigInteger s = new BigInteger(String.valueOf(second));
        int count = 0;
        for (int i = 0; i < 40_000_000; i++) {
            f = f.multiply(BigInteger.valueOf(16807));
            s = s.multiply(BigInteger.valueOf(48271));
            BigInteger rem1 = f.remainder(BigInteger.valueOf(2147483647));
            BigInteger rem2 = s.remainder(BigInteger.valueOf(2147483647));
            boolean eq = true;
            for (int j = 0; j < 16; j++) {
                if (rem1.testBit(j) != rem2.testBit(j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                count++;
            }
            //System.out.println(rem1 + " " + rem2);
            f = rem1;
            s = rem2;
        }
        return count;
    }

    private static int solve2(int first, int second) {
        BigInteger f = new BigInteger(String.valueOf(first));
        BigInteger s = new BigInteger(String.valueOf(second));
        int count = 0;
        for (int i = 0; i < 5_000_000; i++) {
            while (true) {
                f = f.multiply(BigInteger.valueOf(16807));
                f = f.remainder(BigInteger.valueOf(2147483647));
                if (f.remainder(BigInteger.valueOf(4)).equals(BigInteger.ZERO))
                    break;
            }
            while (true) {
                s = s.multiply(BigInteger.valueOf(48271));
                s = s.remainder(BigInteger.valueOf(2147483647));
                if (s.remainder(BigInteger.valueOf(8)).equals(BigInteger.ZERO))
                    break;
            }
            boolean eq = true;
            for (int j = 0; j < 16; j++) {
                if (f.testBit(j) != s.testBit(j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                count++;
            }
        }

        return count;
    }

}
