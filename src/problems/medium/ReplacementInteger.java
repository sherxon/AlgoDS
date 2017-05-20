package problems.medium;

/**
 * Created by sherxon on 1/13/17.
 */
public class ReplacementInteger {
    public static void main(String[] args) {
        ReplacementInteger ir = new ReplacementInteger();
        System.out.println(ir.integerReplacement(65535));

    }

    public int integerReplacement(int m) {
        long n = (long) m;
        long counter = 0;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else {
                if (n != 3 && maxPow2(n + 1) > maxPow2(n - 1)) n += 1;
                else n -= 1;
            }
            counter++;
        }
        return Long.valueOf(counter).intValue();
    }

    long maxPow2(long a) {
        if ((a & (a - 1)) == 0) {
            return Long.bitCount(a - 1);
        }
        long count = 0;
        while (a % 2 == 0) {
            a /= 2;
            count++;
        }
        return count;
    }
}
