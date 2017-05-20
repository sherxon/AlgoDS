package algo;

import problems.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 1/3/17.
 */
public class TreeTraversals {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("InOrder");
        inOrder(root);
        System.out.println();
        System.out.println("PreOrder");
        preOrder(root);
        System.out.println();
        System.out.println("PostOrder");
        postOrder(root);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // add first level to queue
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode x = q.remove();
            level--;
            if (x.left != null)
                q.add(x.left);
            if (x.right != null)
                q.add(x.right);

            if (level == 0 && !q.isEmpty()) {
                level += q.size();
                System.out.println(q);
            }
        }
    }
}
