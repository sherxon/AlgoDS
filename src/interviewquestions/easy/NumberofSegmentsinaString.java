package interviewquestions.easy;

/**
 * Created by sherxon on 1/13/17.
 */
public class NumberofSegmentsinaString {
    public static int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int i = 0, count = 0;
        while (i < s.length()) {
            if (i > 0 && s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') count++;
            i++;
        }

        return count + 1;
    }
}
