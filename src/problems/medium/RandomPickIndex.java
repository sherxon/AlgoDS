package problems.medium;

import java.util.Random;

/**
 * Created by sherxon on 1/16/17.
 */
public class RandomPickIndex {
    /*Map<Integer, List<Integer>> map = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomPickIndex.pick(3));
        }
    }

    public int pick(int target) {
        int random = (int) (Math.random() * map.get(target).size());
        return map.get(target).get(random);
    }*/

    /**
     * This is reservoir sample solution
     */
    Random random;
    int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != target) {
                continue;
            }

            if (random.nextInt(++count) == 0) {
                result = i;
            }

        }
        return result;
    }


}
