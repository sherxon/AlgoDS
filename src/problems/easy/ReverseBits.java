package problems.easy;

import java.util.HashSet;

/**
 * Created by sherxon on 1/6/17.
 */
public class ReverseBits {
    /**
    * Reversing bits and returning integer.
    * */
    public int reverseBits(int n) {
        HashSet<Integer> set= new HashSet<>();

        String padding = "00000000000000000000000000000000"; //
        String result = padding + Integer.toBinaryString(n);
        result = result.substring(result.length() - 32, result.length());  // take the right-most 64 digits

        char[] a = result.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = a.length - 1; i >= 0; i--)
            sb.append(a[i]);

        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
