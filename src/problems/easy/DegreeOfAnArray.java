package problems.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        int maxE = 0;
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], new LinkedList<>());
            }
            map.get(a[i]).add(i);
            int size = map.get(a[i]).size();
            if (size > max) {
                max = size;
                maxE = a[i];
            } else if (size == max && size > 1) {
                LinkedList<Integer> list1 = (LinkedList<Integer>) map.get(maxE);
                LinkedList<Integer> list2 = (LinkedList<Integer>) map.get(a[i]);
                int diff1 = list1.getLast() - list1.getFirst();
                int diff2 = list2.getLast() - list2.getFirst();
                if (diff2 < diff1)
                    maxE = a[i];
            }
        }
        LinkedList<Integer> list = (LinkedList<Integer>) map.get(maxE);
        if (list.size() == 1)
            return 1;
        return list.getLast() - list.getFirst() + 1;
    }
}
