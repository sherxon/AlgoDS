package interviewquestions.easy;

/**
 * Created by sherxon on 1/13/17.
 */
public class NumberofSegmentsinaString {
    public static int countSegments(String s) {
        if (s.length() == 0) return 0;
        s = s.trim();
        if (s.length() == 1 && s.charAt(0) != ' ') return 1;
        int counter = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (i == 0 && s.charAt(i) != ' ') counter++;
            else if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') counter++;
        }

        return counter;
    }
}
