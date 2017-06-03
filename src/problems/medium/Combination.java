package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 6/3/17.
 */
public class Combination {

  private static void exec(List<List<Integer>> list, boolean[] b, int k, int i) {
    if (k < 0) {
      return;
    }
    if (k == 0) {
      List<Integer> l = new ArrayList<>();
      for (int j = 1; j < b.length; j++) {
        if (b[j]) {
          l.add(j);
        }
      }
      list.add(l);
    }
    for (int j = i; j < b.length; j++) {
      if (!b[j]) {
        b[j] = true;
        exec(list, b, k - 1, j);
        b[j] = false;
      }
    }

  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> list = new ArrayList<>();

    if (k <= 0 || k > n) {
      return list;
    }
    boolean[] b = new boolean[n + 1];
    exec(list, b, k, 1);
    return list;
  }

}
