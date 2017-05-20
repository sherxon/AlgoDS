package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 1/16/17.
 */
public class RandomPickIndex {
    Map<Integer, List<Integer>> map = new HashMap<>();

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
    }
}
