package interviewquestions.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 3/5/17.
 */
public class LonelyPixelI {
    public int findLonelyPixel(char[][] a) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 'B') {
                    if (!rows.containsKey(i) && !cols.containsKey(j)) {
                        count++;
                        cols.put(j, 1);
                        rows.put(i, 1);
                    } else {
                        if (cols.getOrDefault(j, -1) == 1) {
                            count--;
                            cols.put(j, 2);
                        }
                        if (rows.getOrDefault(i, -1) == 1) {
                            count--;
                            rows.put(i, 2);
                        }
                    }
                }
            }
        }
        return count < 0 ? 0 : count;
    }
}
