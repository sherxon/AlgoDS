package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 5/28/17.
 */
public class MinimumIndexSumOfTwoLists {

  public String[] findRestaurant(String[] list1, String[] list2) {
    if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) {
      return new String[]{};
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }

    Map<Integer, Set<String>> res = new HashMap<>();

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < list2.length; i++) {
      String ss = list2[i];
      if (map.containsKey(ss)) {
        int index = map.get(ss);
        if (!res.containsKey(i + index)) {
          res.put(i + index, new HashSet<>());
        }
        res.get(i + index).add(ss);

        min = Math.min(min, i + index);
      }
    }
    int size = res.get(min).size();
    String[] ret = new String[size];
    int j = 0;
    for (String f : res.get(min)) {
      ret[j++] = f;
    }
    return ret;

  }

}
