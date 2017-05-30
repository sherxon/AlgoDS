package contests.contest34;

import java.util.Arrays;

/**
 * Created by sherxon on 5/27/17.
 */
public class ArrayNesting {

  public static void main(String[] args) {
    System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    for (int i = 0; i < 65; i++) {
      System.out.println(Integer.toBinaryString(i) + " " + i);
    }
  }

  static public int arrayNesting(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] a = new int[nums.length];
    int counter = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > 0) {
        continue;
      }
      int j = i;
      counter++;
      while (a[j] == 0) {
        a[j] = counter;
        j = nums[j];
      }
    }
    int max = 0;
    System.out.println(Arrays.toString(a));
    for (int ii : a) {
      max = Math.max(max, a[ii]);
    }
    return max;
  }

}
