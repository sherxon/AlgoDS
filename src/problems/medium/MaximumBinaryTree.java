package problems.medium;

import problems.utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] a) {
        if(a==null || a.length==0)return null;
        return go(a, 0, a.length-1);
    }
    
    TreeNode go(int[]a, int lo, int hi){
        if(lo>hi)return null;
        if(hi==lo)return new TreeNode(a[lo]);
        int max=Integer.MIN_VALUE;
        int maxi=0;
        for(int i=lo; i<=hi; i++){
            if(a[i]>max){
                max=a[i];
                maxi=i;
            }
        }
        TreeNode root= new TreeNode(a[maxi]);
        root.left=go(a, lo, maxi-1);
        root.right=go(a, maxi+1, hi);
        return root;
    }
}
