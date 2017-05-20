package problems.medium;

/**
 * Created by sherxon on 1/17/17.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int os = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) os++;
            else if (nums[i] == 1) ones++;
            else twos++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (os > 0) {
                nums[i] = 0;
                os--;
            } else if (ones > 0) {
                nums[i] = 1;
                ones--;
            } else {
                nums[i] = 2;
            }
        }

    }
}
