package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 2/26/17.
 */
public class MinimumAbsoluteDifferenceinBST {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    void inorder(TreeNode x) {
        if (x == null) return;
        inorder(x.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev.val - x.val));
        }
        prev = x;
        inorder(x.right);

    }
}
