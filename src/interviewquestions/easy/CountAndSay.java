package interviewquestions.easy;

/**
 * Created by sherxon on 1/16/17.
 */
public class CountAndSay {
    /**
     * We build the count and say sequence starting from 1.
     */
    public static String countAndSay(int n) {
        if (n < 1) return "";
        StringBuilder sb = new StringBuilder();
        String last = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            char prev = last.charAt(0);
            for (int j = 1; j < last.length(); j++) {
                if (last.charAt(j) == prev) count++;
                else {
                    sb.append(count);
                    sb.append(prev);
                    prev = last.charAt(j);
                    count = 1;
                }
            }
            if (count > 0) {
                sb.append(count);
                sb.append(prev);
            }
            last = sb.toString();
            sb.setLength(0);
        }
        return last;
    }
}
