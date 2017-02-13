package contests;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by sherxon on 2/11/17.
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] a = new int[50000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10000);
        }
        System.out.println(reversePairs(a));
    }

    static int reversePairs(int[] nums) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new TreeSet<>());
            else
                map.get(nums[i]).add(i);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int level = nums[i] % 2 == 0 ? (nums[i] / 2) : (nums[i] / 2 + 1);
            SortedMap<Integer, TreeSet<Integer>> sortedMap = map.headMap(level);
            for (Integer integer : sortedMap.keySet()) {
                count += sortedMap.get(integer).tailSet(i, false).size();
            }
        }

        return count;
    }
}
