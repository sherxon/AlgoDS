package problems.easy;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 1/28/17.
 */
public class FindModeinBST {
    int max = 1;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        find(root, map);
        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == max) list.add(integer);
        }
        int[] a = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            a[i++] = integer;
        }

        return a;
    }

    private void find(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        if (map.containsKey(root.val)) {
            int val = map.get(root.val) + 1;
            map.put(root.val, val);
            max = Math.max(max, val);
        } else
            map.put(root.val, 1);

        find(root.left, map);
        find(root.right, map);

    }
}
