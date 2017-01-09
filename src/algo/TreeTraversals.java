package algo;

import interviewquestions.TreeNode;

/**
 * Created by sherxon on 1/3/17.
 */
public class TreeTraversals {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        System.out.println("InOrder");
        inOrder(root);
        System.out.println();
        System.out.println("PreOrder");
        preOrder(root);
        System.out.println();
        System.out.println("PostOrder");
        postOrder(root);
    }

    private static void postOrder(TreeNode root) {
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    private static void preOrder(TreeNode root) {
        if(root==null)return;
        // logic goes first
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(TreeNode root) {
        if(root==null)return;
        inOrder(root.left);
        // logic goes here
        System.out.print(root.val + " ");

        inOrder(root.right);

    }
}
