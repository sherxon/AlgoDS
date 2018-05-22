package problems.medium;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 1/3/17.
 */
public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        new FlattenBinaryTreetoLinkedList().flatten2(root);
    }

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.left);
        flatten2(root.right);

        TreeNode left = root.left;
        root.left = null;
        if (left != null) {
            TreeNode t = left;
            while (t.right != null)
                t = t.right;
            t.right = root.right;
            root.right = left;
        }
    }

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
