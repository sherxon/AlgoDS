package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 1/12/17.
 */
public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < q.val && root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
