package problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class ReorderedPowerof2 {
    public boolean reorderedPowerOf2(int n) {
        if (n == 1 || ((n - 1) & n) == 0)
            return true;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 33; i++) {
            set.add(String.valueOf((int) Math.pow(2, i)));
        }
        for (String s : set) {
            if (isAnagram(s, String.valueOf(n))) {
                return true;
            }
        }
        return false;
    }

    boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] c = new int[255];
        for (int i = 0; i < a.length(); i++) {
            c[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            c[b.charAt(i)]--;
            if (c[b.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
