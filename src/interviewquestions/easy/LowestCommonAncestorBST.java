package interviewquestions.easy;

import interviewquestions.TreeNode;

/**
 * Created by sherxon on 1/12/17.
 */
public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        System.out.println(0 % 2);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < q.val && root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
