package problems.easy;

import problems.utils.TreeNode;

/**
 * solution
 */
public class TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int l, int r) {
        if(root==null)return null;

        root.left=trimBST(root.left, l, r);
        root.right=trimBST(root.right, l, r);

        if(root.val < l)
            return root.right;
        else if(root.val > r)
            return root.left;

        return root;
    }
}
