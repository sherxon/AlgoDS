package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 2016-12-29.
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)return 0;
        int ls=sumOfLeftLeaves(root.left);
        int rs=sumOfLeftLeaves(root.right);
        if(root.left!=null && root.left.left==null && root.left.right==null)
            ls+=root.left.val;
        return ls+rs;
    }
}
