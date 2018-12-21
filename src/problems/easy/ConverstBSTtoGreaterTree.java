package problems.easy;

import problems.utils.TreeNode;

/**
 * Why Did you create this class? what does it do?
 */
public class ConverstBSTtoGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        go(root);
        return root;
    }

    int go(TreeNode x) {
        if (x == null)
            return 0;
        int right = go(x.right);
        sum += x.val;
        x.val = sum;
        int left = go(x.left);
        return x.val;
    }
}
