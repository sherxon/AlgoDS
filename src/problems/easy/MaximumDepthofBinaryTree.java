package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 2016-12-24.
 */

/**
 * Given Binary Tree, return maximum depth of binary tree.
 */
public class MaximumDepthofBinaryTree {
    /**
     * Find height of both left and right subtree and return max of them plus one
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
