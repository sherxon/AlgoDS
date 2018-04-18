package amazon.tamru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
}
