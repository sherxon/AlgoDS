package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 5/28/17.
 */
public class CombinationSum3 {

  static public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new ArrayList<>();
    if (k == 0 || n == 0) {
      return list;
    }
    boolean[] a = new boolean[10];
    go(k, n, list, a, 1);
    return list;
  }

  static void go(int k, int n, List<List<Integer>> list, boolean[] a, int j) {
    if (n < 0 || k < 0) {
      return;
    }

    if (n == 0 && k == 0) {
      List<Integer> l = new ArrayList<>();
      for (int i = 0; i < a.length; i++) {
        if (a[i]) {
          l.add(i);
        }
      }
      list.add(l);
    } else {
      for (int i = j; i < a.length; i++) {
        if (!a[i] && n - i >= 0 && k > 0) {
          a[i] = true;
          go(k - 1, n - i, list, a, i + 1);
          a[i] = false;
        }
      }

    }
  }

}
