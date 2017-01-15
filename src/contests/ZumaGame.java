package contests;

/**
 * Created by sherxon on 1/14/17.
 */
public class ZumaGame {
    public static void main(String[] args) {
        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
    }

    static int findMinStep(String board, String hand) {
        StringBuilder s = new StringBuilder(board);
        StringBuilder h = new StringBuilder(hand);
        int count = 0;
        while (s.length() != 0 && h.length() != 0) {
            String f = s.substring(0, 1);
            int index = s.indexOf(f, 2);
            if (index != -1) {
                s.append(f);
            } else {
                int i = h.indexOf(f);
                if (i == -1) return -1;
                h.delete(i, i + 1);
                s.insert(0, f);
                count++;
            }
            if (s.length() > 2 && s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2)) {
                s.delete(0, 3);
            }
        }

        return count == 0 || s.length() > 0 ? -1 : count;
    }
}
