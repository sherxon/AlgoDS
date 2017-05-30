package problems.medium;

/**
 * Created by sherxon on 1/2/17.
 */
public class ShuffleanArray {
    int [] a;
    int [] nums;

    public ShuffleanArray(int[] nums) {
        this.nums=nums;
        a= new int[nums.length];
        System.arraycopy(nums, 0, a, 0, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0; i<a.length; i++){
            int rand=(int) (Math.random()* (a.length));
            int temp=a[i];
            a[i]=a[rand];
            a[rand]=temp;
        }
        return a;
    }
}
