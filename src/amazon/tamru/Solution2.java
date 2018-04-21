package amazon.tamru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class Solution2 {
    public static void main(String[] args) {
        Set<Long> k = (Set<Long>) null;
        System.out.println(k);

        System.out.println(new Solution2().reorderLines(5, Arrays.asList(
                "a1 9 2 3 1",
                "g1 act car",
                "zo4 4 7",
                "ab1 off key dog",
                "a8 act zoo "
        )));
        System.out.println(new Solution2().reorderLines(5, Arrays.asList(
                "r1 box ape bit",
                "br8 eat nim did",
                "w1 has uni gray",
                "b4 xi me nu"
        )));

    }

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        if (logFileSize <= 1 || logLines.size() <= 1)
            return logLines;
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        for (String logLine : logLines) {
            String[] s = logLine.split(" ");
            if (Character.isDigit(s[1].charAt(0)))
                numbers.add(logLine);
            else
                letters.add(logLine);
        }
        letters.sort((a, b) -> {
            String[] aspl = a.split(" ");
            String[] bspl = b.split(" ");
            String alog = a.substring(aspl[0].length());
            String blog = b.substring(bspl[0].length());
            System.out.println(alog + " => " + blog);
            int diff = alog.compareTo(blog);
            if (diff < 0)
                return -1;
            if (diff > 0)
                return 1;
            return aspl[0].compareTo(bspl[0]);
        });
        letters.addAll(numbers);
        return letters;

    }

    public String originalDigits(String s) {
        if (s == null || s.length() == 0)
            return s;
        int[] a = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c]++;
        }
        // one nine
        List<Integer> b = new ArrayList<>();

        add(b, 6, a['x']);
        a['s'] -= a['x'];
        a['i'] -= a['x'];
        a['x'] = 0;

        add(b, 8, a['g']);
        a['e'] -= a['g'];
        a['i'] -= a['g'];
        a['t'] -= a['g'];
        a['h'] -= a['g'];
        a['g'] = 0;

        add(b, 2, a['w']);
        a['t'] -= a['w'];
        a['o'] -= a['w'];
        a['w'] = 0;

        add(b, 0, a['z']);
        a['e'] -= a['z'];
        a['r'] -= a['z'];
        a['o'] -= a['z'];
        a['z'] = 0;

        add(b, 3, a['r']);
        a['t'] -= a['r'];
        a['h'] -= a['r'];
        a['e'] -= a['r'];
        a['e'] -= a['r'];
        a['r'] = 0;

        add(b, 4, a['u']);
        a['f'] -= a['u'];
        a['o'] -= a['u'];
        a['r'] -= a['u'];
        a['u'] = 0;

        add(b, 7, a['s']);
        a['e'] -= a['s'];
        a['v'] -= a['s'];
        a['e'] -= a['s'];
        a['n'] -= a['s'];
        a['s'] = 0;

        add(b, 5, a['v']);
        a['f'] -= a['v'];
        a['i'] -= a['v'];
        a['e'] -= a['v'];
        a['v'] = 0;

        add(b, 5, a['o']);
        a['n'] -= a['o'];
        a['e'] -= a['o'];
        a['o'] = 0;

        add(b, 9, a['i']);
        return b.stream().sorted().map(String::valueOf).collect(Collectors.joining(""));

    }

    void add(List<Integer> b, int s, int k) {
        for (int i = 0; i < k; i++) {
            b.add(s);
        }
    }
}
