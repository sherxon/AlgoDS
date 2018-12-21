package problems.medium;

import problems.utils.TreeNode;

/**
 * Why Did you create this class? what does it do?
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;
        if (prune(root) && root.val == 0) {
            return null;
        }
        return root;
    }

    boolean prune(TreeNode x) {
        if (x == null)
            return true;
        boolean l = prune(x.left);
        boolean r = prune(x.right);
        if (l)
            x.left = null;
        if (r)
            x.right = null;
        return x.val == 0 && x.right == null && x.left == null;
    }
}
