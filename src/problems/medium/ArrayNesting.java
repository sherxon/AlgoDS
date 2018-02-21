package problems.medium;

/**
 * Created by sherxon on 5/28/17.
 */
public class ArrayNesting {

  public int arrayNesting(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] a = new int[nums.length];
    int counter = 1;
    int max = 0;
    for (int i = 0; i < a.length; i++) {
      int j = i;
      int k = 0;
      while (a[j] == 0) {
        a[j] = counter;
        j = nums[j];
        k++;
      }
      counter++;
      max = Math.max(k, max);
    }
    return max;
  }
}
