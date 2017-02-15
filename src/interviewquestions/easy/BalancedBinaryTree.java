package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 12/30/16.
 */
// there are 3 ways to break recursion stack
//1) return magic number like below example(-1)
//2) throw exception
//3) use global variable and discard whenever global variable changed
public class BalancedBinaryTree {
    // first way using global variable

    boolean b=true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        size(root);
        return b;
    }
    int size(TreeNode x){
        if(x==null)return 0;
        int ls=size(x.left);
        int rs=size(x.right);
        if(Math.abs(ls-rs)>1)b=false;
        return Math.max(ls, rs)+1;
    }
    // second way return magic number

    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        return dfs(root)!=-1;
    }

    private int dfs(TreeNode root) {
        if(root==null)return 0;

        int leftsize=dfs(root.left);
        if(leftsize==-1)return -1;

        int rightsize=dfs(root.right);
        if(rightsize==-1)return -1;

        if(Math.abs(rightsize-leftsize)>1)return -1;
        return Math.max(leftsize, rightsize)+1;
    }

    public boolean isBalanced3(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) < 2 && isBalanced3(root.left) && isBalanced3(root.right);
    }

    int height(TreeNode x) {
        if (x == null) return 0;
        return Math.max(height(x.left), height(x.right)) + 1;
    }

}
