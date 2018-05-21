package problems.hard;

/**
 * Why Did you create this class? what does it do?
 */
public class InterleavingStrings {
    public static void main(String[] args) {
        System.out.println(new InterleavingStrings().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    boolean found = false;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        if (Math.min(s1.length(), s2.length()) == 0 && (s3.equals(s1) || s3.equals(s2)) && s3.length() > 0)
            return true;
        go(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
        return found;
    }

    void go(char[] a, char[] b, char[] c, int i, int j, int k) {
        if (found)
            return;
        if (k >= c.length) {
            if (i > 0 && j > 0)
                found = true;
            return;
        }

        if (i < a.length && a[i] == c[k]) {
            go(a, b, c, i + 1, j, k + 1);
        }
        if (j < b.length && b[j] == c[k]) {
            go(a, b, c, i, j + 1, k + 1);
        }

    }
}
