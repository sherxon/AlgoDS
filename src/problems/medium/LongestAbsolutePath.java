package problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 4/27/17.
 */
public class LongestAbsolutePath {

    public int lengthLongestPath(String input) {
        if (input == null || !input.contains("."))
            return 0;
        Map<Integer, String> map = new HashMap<>();
        String[] lines = input.split("\n");
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            String current = lines[i];
            int tabCount = getTabCount(current);
            if (current.contains(".")) {
                int size = getAbsPathSize(map, tabCount);
                max = Math.max(max, size + current.substring(tabCount).length());
            } else {
                map.put(tabCount, current.substring(tabCount));
            }
        }

        return max;
    }

    private int getAbsPathSize(Map<Integer, String> map, int ts) {
        int size = 0;
        for (int i = 0; i < ts; i++) {
            size += map.get(i).length() + 1;
        }
        return size;
    }

    private int getTabCount(String current) {
        int i = 0;
        while (i < current.length()) {
            if (current.charAt(i) == '\t')
                i++;
            else
                return i;
        }
        return i;
    }
}
