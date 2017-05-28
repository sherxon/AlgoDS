package problems.easy;

/**
 * Created by sherxon on 5/28/17.
 */
public class RangeAddition2 {

  public int maxCount(int m, int n, int[][] ops) {
    if (ops == null || ops.length == 0 || ops[0].length == 0) {
      return m * n;
    }
    int x = ops[0][0];
    int y = ops[0][1];
    for (int[] a : ops) {
      x = Math.min(a[0], x);
      y = Math.min(a[1], y);
    }
    return x * y;
  }

}
