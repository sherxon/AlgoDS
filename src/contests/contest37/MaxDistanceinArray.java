package contests.contest37;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by sherxon on 6/17/17.
 */
public class MaxDistanceinArray {

  public static void main(String[] args) {
  }

  public int maxDistance(int[][] a) {
    if (a == null || a.length == 0) {
      return 0;
    }

    TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
    for (int i = 0; i < a.length; i++) {
      if (!map.containsKey(a[i][0])) {
        map.put(a[i][0], new HashSet<>());
      }
      if (!map.containsKey(a[i][a[i].length - 1])) {
        map.put(a[i][a[i].length - 1], new HashSet<>());
      }
      map.get(a[i][a[i].length - 1]).add(i);
      map.get(a[i][0]).add(i);
    }
    int res = Math.abs(map.firstKey() - map.lastKey());
    if (map.firstEntry().getValue().size() > 1 || map.lastEntry().getValue().size() > 1) {
      return res;
    }
    if (map.firstEntry().getValue().iterator().next()
        .equals(map.lastEntry().getValue().iterator().next())) {
      int min = map.firstKey();
      map.pollFirstEntry();
      int min2 = map.firstKey();
      int max = map.lastKey();
      map.pollLastEntry();
      int max2 = map.lastKey();
      return Math.max(Math.abs(max - min2), Math.abs(max2 - min));
    }
    return 0;
  }

}
