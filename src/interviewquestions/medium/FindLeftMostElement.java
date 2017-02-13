package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.TreeMap;

/**
 * Created by sherxon on 2/12/17.
 */

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 */
public class FindLeftMostElement {

    public int findBottomLeftValue(TreeNode root) {
        return findLeftMostNode(root);
    }

    public int findLeftMostNode(TreeNode root) {
        if (root == null) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b.compareTo(a));
        find(root, 0, map);
        if (map.size() == 0) return root.val;
        return map.values().iterator().next();
    }

    private void find(TreeNode root, int i, TreeMap<Integer, Integer> map) {
        if (root == null) return;
        if (!map.containsKey(i)) map.put(i, root.val);
        if (root.left != null) find(root.left, i + 1, map);
        if (root.right != null) find(root.right, i + 1, map);
    }
}
