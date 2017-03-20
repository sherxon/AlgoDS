package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 12/24/16.
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
