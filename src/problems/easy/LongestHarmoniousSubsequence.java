package problems.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by sherxon on 5/20/17.
 */
public class LongestHarmoniousSubsequence {

  public static void main(String[] args) {
    System.out.println(findLHS(new int[]{1, 1, 1, 1}));
  }

  static public int findLHS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
    }
    Integer prev = null;
    int max = 0;
    for (Integer key : map.keySet()) {
      if (prev != null && (key - 1 == prev || key + 1 == prev)) {
        max = Math.max(map.get(prev) + map.get(key), max);
      }
      prev = key;
    }

    return max;
  }

}
