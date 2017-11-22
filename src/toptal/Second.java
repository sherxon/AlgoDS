package toptal;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class Second {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1 }));
    }

    static public int solution(int[] a) {
        // write your code in Java SE 8
        if (a == null || a.length == 0)
            return 0;
        StringBuilder sb = new StringBuilder(a.length);
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        sb = sb.reverse();
        BigInteger integer = new BigInteger(sb.toString());
        integer = integer.multiply(BigInteger.valueOf(17));
        int result = 0;
        String s = integer.toString();
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) - '0';
        }
        return result;
    }
}
