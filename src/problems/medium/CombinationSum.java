package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 6/3/17.
 */
public class CombinationSum {

  public static void main(String[] args) {
    System.out.println(combinationSum(new int[]{7, 6, 3, 2}, 7));
  }

  static public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    if (target == 0 || candidates.length == 0) {
      return list;
    }
    List<Integer> l = new ArrayList<>();
    go(candidates, target, target, list, l, 0);
    return list;
  }

  private static void go(int[] candidates, int x, int target, List<List<Integer>> list,
      List<Integer> l, int i) {
    if (x < 0) {
      return;
    }
    if (x == 0) {
      list.add(l);
    } else {
      for (int j = 0; j < candidates.length; j++) {
        int xx = x - candidates[j];
        if (xx >= 0) {
          l.add(candidates[j]);
          go(candidates, xx, target, list, l, i);
        }

      }
    }

  }

}
