package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 2/4/17.
 */
public class MostFrequentSubtreeSum {
    static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> fr = new HashMap<>();
        sumNodes(root, fr);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Integer integer : fr.keySet()) {
            if (fr.get(integer) > max) {
                list.clear();
                max = fr.get(integer);
            }
            if (fr.get(integer) == max)
                list.add(integer);
        }
        int[] a = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            a[i++] = integer;
        }
        return a;
    }

    static int sumNodes(TreeNode x, Map<Integer, Integer> fr) {
        if (x == null) return 0;
        x.val = sumNodes(x.left, fr) + sumNodes(x.right, fr) + x.val;
        fr.put(x.val, fr.getOrDefault(x.val, 0) + 1);
        return x.val;
    }
}
