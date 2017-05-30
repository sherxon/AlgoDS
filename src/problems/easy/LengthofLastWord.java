package problems.easy;

/**
 * Created by sherxon on 1/22/17.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') return s.length() - i - 1;
        }
        return s.length();
    }
}
