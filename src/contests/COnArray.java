package contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sherxon on 2/18/17.
 */
public class COnArray {
    int[] a = new int[26];

    public static void main(String[] args) {
        System.out.println(new COnArray().findAnagrams(
                "cbaebabacd",
                "abc"
        ));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) return list;
        int sum = hash(p);
        int h = hash(s.substring(0, p.length()));
        for (int i = 1; i <= s.length() - p.length() + 1; i++) {
            if (sum == h && valid(p, s.substring(i, i + p.length() - 1))) list.add(i - 1);
            if (i + p.length() - 1 < s.length())
                h += s.charAt(i + p.length() - 1);
            h -= s.charAt(i - 1);
        }
        return list;
    }

    int hash(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h += s.charAt(i);
        }
        return h;
    }

    boolean valid(String s, String t) {
        Arrays.fill(a, 0);
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (a[index] == 0) return false;
            a[index]--;
        }
        return true;

    }
}
