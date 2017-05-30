package problems.medium;

import java.util.Arrays;

/**
 * Created by sherxon on 4/28/17.
 */
public class NextPermutation {
    /**
    * Solution Idea, first find an element whose left element is smaller than its value
    * then walk through the array from current index to find min element that is also larger than current element
    * swap min element with current element and sort the array from current index to end
    * */
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1; i>0; i--){

            if(nums[i] > nums[i-1]){

                int min=Integer.MAX_VALUE;
                int mini=i-1;
                for(int j=i; j<nums.length; j++){
                    if(nums[j] <= nums[i-1])continue;

                    if(nums[j] < min){
                        min=nums[j];
                        mini=j;
                    }
                }

                int temp=nums[i-1];
                nums[i-1]=nums[mini];
                nums[mini]=temp;
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
