package problems.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 2016-12-26.
 */
public class ContainsDuplicateII {
    /**
     * Maintain every element with last encountered index in the array. In each loop iteration check if
     * this element is in map and check last encountered index to decide.
     */
    public boolean containsNearbyDuplicate(int[] a, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i]) && i- map.get(a[i]) <=k)return true;
            map.put(a[i], i);
        }

        return false;
    }

    /**
     * This is sliding windows solution.
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
