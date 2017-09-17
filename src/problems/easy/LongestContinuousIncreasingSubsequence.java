package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int count=0;
        if(nums==null || nums.length<=1)
            return nums.length;

        int c=1;
        for(int j=1; j<nums.length; j++){
            if(nums[j-1] < nums[j]){
                c++;
            }else{
                c=1;
            }
            count=Math.max(count, c);
        }
        return count;
    }
}
