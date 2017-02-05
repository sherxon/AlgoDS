package contests;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by sherxon on 2/4/17.
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(
                new int[]{2, 4},
                new int[]{1, 2, 3, 4}
        )));
    }

    static int[] nextGreaterElement(int[] findNums, int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[findNums.length];
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < findNums.length; i++) {
            NavigableMap<Integer, Integer> part = map.tailMap(findNums[i], false);
            int old = map.get(findNums[i]);
            int min = Integer.MAX_VALUE;
            int val = -1;
            for (Integer integer : part.keySet()) {
                if (part.get(integer) > old && min > part.get(integer)) {
                    min = part.get(integer);
                    val = integer;
                }
            }
            a[i] = val;
        }
        return a;
    }
}
