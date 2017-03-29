package interviewquestions.hard;

/**
 * Created by sherxon on 3/28/17.
 */

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 */
public class ShortestPalindrome {
    /**
     * To solve this problem, we can use KMP algorithm
     */
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String reverse = new StringBuilder(s).reverse().toString();
        String l = s + "#" + reverse;
        // now we have to find longest prefix that is equal to suffix from big string;
        int[] p = new int[l.length()];
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j))
                j = p[j - 1];

            if (l.charAt(i) == l.charAt(j))
                p[i] = j + 1;
        }
        return reverse.substring(0, s.length() - p[l.length() - 1]) + s;

    }
}
