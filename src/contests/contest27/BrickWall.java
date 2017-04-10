package contests.contest27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 4/8/17.
 */
public class BrickWall {

    static public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            sum += wall.get(0).get(i);
        }
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> row = wall.get(i);
            int value = 1;
            if (map.containsKey(row.get(0)))
                value = map.get(row.get(0)) + 1;
            map.put(row.get(0), value);
            if (row.get(0) != sum)
                max = Math.max(value, max);
            for (int j = 1; j < row.size(); j++) {
                row.set(j, row.get(j) + row.get(j - 1));
                value = 1;
                if (map.containsKey(row.get(j)))
                    value = map.get(row.get(j)) + 1;
                map.put(row.get(j), value);
                if (row.get(j) != sum)
                    max = Math.max(value, max);
            }
        }
        return wall.size() - max;
    }
}
