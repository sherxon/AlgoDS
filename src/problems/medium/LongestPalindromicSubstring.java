package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        String max = String.valueOf(s.charAt(0));
        char[] a = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int[] p1 = pal(a, i, i);
            if (p1[1] - p1[0] > max.length()) {
                max = s.substring(p1[0], p1[1]);
            }
            p1 = pal(a, i, i + 1);
            if (p1[1] - p1[0] > max.length()) {
                max = s.substring(p1[0], p1[1]);
            }

        }
        return max;
    }

    int[] pal(char[] a, int i, int j) {

        while (i >= 0 && j < a.length) {
            if (a[i] != a[j]) {
                return new int[] { i + 1, j };
            }
            i--;
            j++;
        }
        return new int[] { i + 1, j };
    }
}
