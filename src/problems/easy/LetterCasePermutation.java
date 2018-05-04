package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println((new LetterCasePermutation().letterCasePermutation("a1b2C")));
    }

    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add(s.toLowerCase());
        go(s.toLowerCase().toCharArray(), 0, res);
        return res;
    }

    private void go(char[] a, int i, List<String> res) {
        if (i >= a.length)
            return;
        if (Character.isDigit(a[i])) {
            go(a, i + 1, res);
            return;
        }

        if (Character.isLowerCase(a[i])) {
            go(a, i + 1, res);
            a[i] = Character.toUpperCase(a[i]);
            String upper = new String(a);
            go(upper.toCharArray(), i + 1, res);
        } else {
            go(a, i + 1, res);
            a[i] = Character.toLowerCase(a[i]);
            go(new String(a).toCharArray(), i + 1, res);
        }
        res.add(new String(a));
    }
}
