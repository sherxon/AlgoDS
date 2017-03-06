package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 3/5/17.
 */

/**
 * Diameter of binary tree
 */
public class WidthOfBinaryTree {

    public int width(TreeNode root) {
        if (root == null) return 0;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        int leftDiameter = width(root.left);
        int rightDiameter = width(root.right);
        return Math.max(heightLeft + heightRight + 1, Math.max(leftDiameter, rightDiameter));
    }

    private int height(TreeNode x) {
        if (x == null) return 0;
        return Math.max(height(x.left), height(x.right)) + 1;
    }
}
