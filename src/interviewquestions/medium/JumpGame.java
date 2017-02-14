package interviewquestions.medium;

import java.util.*;

/**
 * Created by sherxon on 2/13/17.
 */

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{
                //3,2,1,0,4
                //2,3,1,1,4
                2, 0
                //1,0
        }));
    }

    static boolean canJump(int[] a) {
        if (a.length == 0) return true;
        if (a.length == 1) return true;
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < i) return false;
            if (max >= a.length - 1) return true;
            max = Math.max(i + a[i], max);
        }
        return max >= a.length - 1;
    }

    public boolean canJump2(int[] a) {
        if (a.length == 0) return true;
        if (a.length == 1) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>(a.length);
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new HashSet<>());
            }
            for (int j = i + 1; j < a[i] + i + 1; j++) {
                map.get(i).add(j);
            }
        }


        boolean[] visited = new boolean[a.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer x = q.remove();
            for (Integer integer : map.get(x)) {
                if (integer == a.length - 1) return true;
                if (!visited[integer]) {
                    visited[integer] = true;
                    q.add(integer);
                }

            }
        }
        return false;
    }
}
