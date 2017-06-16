package google;

import java.math.BigInteger;

/**
 * Created by sherxon on 6/15/17.
 */
public class PowerHungry {

  public static void main(String[] args) {
    String res = answer(new int[]{0, 0, 0, -1, 4, -1, -2});
    System.out.println(res);
  }

  private static String answer(int[] a) {

    if (a == null || a.length == 0) {
      return "";
    }

    if (a.length == 1) {
      return String.valueOf(a[0]);
    }

    BigInteger res = null;

    int negatives = 0;
    int positives = 0;

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {

      if (a[i] == 0) {
        continue;
      }

      if (a[i] < 0) {
        negatives++;
        max = Math.max(max, a[i]);
      } else {
        positives++;
      }

      if (res == null) {
        res = BigInteger.valueOf(a[i]);
      } else {
        res = res.multiply(BigInteger.valueOf(a[i]));
      }
    }

    if (res == null) {
      return "0";
    }

    if (res.compareTo(BigInteger.ZERO) < 0) {
      if (positives == 0 && negatives < a.length) {
        return "0";
      } else if (positives > 0) {
        res = res.divide(BigInteger.valueOf(max));
      }
    }

    return String.valueOf(res);

  }

}
