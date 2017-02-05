package contests;

import java.util.TreeMap;

/**
 * Created by sherxon on 2/4/17.
 */
public class RelativeRanks {
    public static void main(String[] args) {

    }

    static String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b.compareTo(a));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        String[] s = new String[nums.length];
        int i = 1;
        for (Integer integer : map.keySet()) {
            if (i == 1) {
                s[map.get(integer)] = "Gold Medal";
            } else if (i == 2) {
                s[map.get(integer)] = "Silver Medal";
            } else if (i == 3) {
                s[map.get(integer)] = "Bronze Medal";
            } else {
                s[map.get(integer)] = String.valueOf(i);
            }
            i++;
        }
        return s;
    }
}
