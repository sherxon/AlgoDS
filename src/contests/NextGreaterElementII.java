package contests;

/**
 * Created by sherxon on 2/4/17.
 */
public class NextGreaterElementII {
    public static void main(String[] args) {
        //nextGreaterElements(new int[]{1,2,3,4,3});
        nextGreaterElements(new int[]{1, -2, -2, -1});
    }

    static int[] nextGreaterElements(int[] nums) {
        int[] a = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int lo = 0;
            int hi = i + 1;
            int val = Integer.MIN_VALUE;
            int val2 = Integer.MIN_VALUE;
            int minleft = a.length;
            while (hi < nums.length || lo < i) {
                if (hi < nums.length && nums[hi] > nums[i]) {
                    val = nums[hi];
                    break;
                }
                if (lo < i && nums[lo] > nums[i] && minleft > lo) {
                    val2 = nums[lo];
                    minleft = lo;
                }
                if (hi > nums.length && val2 != Integer.MIN_VALUE) break;
                lo++;
                hi++;
            }
            if (val != Integer.MIN_VALUE) a[i] = val;
            else if (val2 != Integer.MIN_VALUE) a[i] = val2;
            else a[i] = -1;
        }

        return a;
    }
}
