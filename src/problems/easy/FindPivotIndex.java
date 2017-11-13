package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int[] reverse = new int[nums.length];
        reverse[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            reverse[i] = nums[i];
            nums[i] += nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            reverse[i] += reverse[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (reverse[i] == nums[i])
                return i;
        }

        return -1;
    }
}
