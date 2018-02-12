package problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class RabbitsinForest {

    public int numRabbits(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int v = map.getOrDefault(a[i], 0);
            map.put(a[i], ++v);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            int v = map.get(key);
            if (key == 0) {
                res += v;
                continue;
            }
            if (key + 1 < v) {
                key++;
                res += key * (Math.ceil(v * 1.0 / key));
            } else {
                res += key + 1;
            }
        }
        return res;
    }
}
