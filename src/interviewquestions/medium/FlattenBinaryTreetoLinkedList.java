package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 1/3/17.
 */
public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        f(root);
        reverse(root);
    }

    void reverse(TreeNode root) {
        if (root == null) return;
        reverse(root.left);
        root.right = root.left;
        root.left = null;
    }

    void f(TreeNode x) {
        while (x != null) {
            TreeNode l = x.left;//left Largest
            while (l != null && l.right != null)
                l = l.right;
            if (l == null) x.left = x.right;
            else l.right = x.right;

            x.right = null;
            x = x.left;
        }
    }
}
