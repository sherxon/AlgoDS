package amazon;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class Amazon {
    public static void main(String[] args) {
        System.out.println(subStringsLessKDist("awaglk", 4));
        System.out.println(subStringsLessKDist("democracy", 5));
        System.out.println(subStringsLessKDist("wawaglknagagwunagkwkwagl", 4));
    }

    static public List<String> subStringsLessKDist(String s, int num) {
        Set<String> set = new HashSet<>();
        if (num < 0 || num > 26 || s == null || s.length() == 0 || s.length() < num)
            return Collections.emptyList();

        int i = 0;
        int j = num - 1;
        char[] a = s.toCharArray();
        while (j < a.length) {
            if (isOk(a, i, j))
                set.add(s.substring(i, j + 1));
            i++;
            j++;
        }

        return new ArrayList<>(set);
    }

    static private boolean isOk(char[] a, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
            set.add(a[k]);
        }

        return set.size() == (j - i);
    }
}
