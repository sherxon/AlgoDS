package interviewquestions.medium;

import interviewquestions.TreeNode;

/**
 * Created by sherxon on 1/5/17.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] a) {
        if(a.length==0)return null;
        return helper(a, 0, a.length-1);
    }

    private TreeNode helper(int[] a, int lo, int hi) {
        if(lo>hi)return null;
        int mid=lo+ (hi-lo)/2;
        TreeNode head=new TreeNode(a[mid]);
        head.left=helper(a, lo, mid-1);
        head.right=helper(a, mid+1, hi);
        return head;
    }
}
