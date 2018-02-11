package problems.easy;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        go(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    void go(TreeNode x, List<Integer> list) {
        if (x == null)
            return;
        go(x.left, list);
        list.add(x.val);
        go(x.right, list);

    }
}
