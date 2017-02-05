package contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sherxon on 2/4/17.
 */
public class KeyboardRow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"m", "k", "r", "tyyy", "k"})));
    }

    static String[] findWords(String[] words) {
        if (words.length == 0) return new String[0];
        int[] a = new int[26];
        for (int i = 0; i < a.length; i++) {
            char c = (char) (i + 'a');
            if (c == 'z' || c == 'x' || c == 'c' || c == 'v' || c == 'b' || c == 'm' || c == 'n')
                a[i] = 3;
            else if (c == 'a' || c == 's' || c == 'd' || c == 'f' || c == 'g' || c == 'h' || c == 'j' || c == 'k' || c == 'l')
                a[i] = 2;
            else if (c == 'q' || c == 'w' || c == 'e' || c == 'r' || c == 't' || c == 'y' || c == 'u' || c == 'i' || c == 'o' || c == 'p')
                a[i] = 1;
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            boolean b = true;
            for (int i = 1; i < chars.length; i++) {
                if (a[chars[i] - 'a'] != a[chars[i - 1] - 'a']) {
                    b = false;
                    break;
                }
            }
            if (b) list.add(word);
        }
        String[] res = new String[list.size()];
        int i = 0;
        for (String s : list) {
            res[i++] = s;
        }
        return res;
    }
}
