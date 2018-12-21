package problems.easy;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Why Did you create this class? what does it do?
 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String s, char c) {
        if (s == null || s.length() == 0)
            return new int[0];
        int[] p = new int[s.length()];
        int[] q = new int[s.length()];

        int k = Integer.MAX_VALUE - 10001;
        int k1 = Integer.MAX_VALUE - 10001;
        for (int i = 0; i < p.length; i++) {
            if (s.charAt(i) == c) {
                k = 0;
            }
            p[i] = k;
            k++;

            if (s.charAt(p.length - i - 1) == c) {
                k1 = 0;
            }
            q[p.length - i - 1] = k1;
            k1++;
        }

        for (int i = 0; i < p.length; i++) {
            p[i] = Math.min(p[i], q[i]);
        }
        return p;
    }

}
