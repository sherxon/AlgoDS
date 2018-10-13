package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (!Character.isAlphabetic(a[i])) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(a[j])) {
                j--;
                continue;
            }
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;

        }

        return new String(a);
    }

}
