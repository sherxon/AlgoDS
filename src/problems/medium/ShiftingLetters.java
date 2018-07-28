package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] a) {
        if (a == null || a.length == 0)
            return s;
        a[a.length - 1] %= 26;
        for (int i = a.length - 2; i >= 0; i--) {
            a[i] = (a[i] + a[i + 1]) % 26;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            c[i] = (char) (a[i] + c[i]);
            if (c[i] > 'z')
                c[i] = (char) (c[i] % 'z' + 'a' - 1);
        }
        return new String(c);
    }
}
