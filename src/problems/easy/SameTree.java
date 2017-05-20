package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 2016-12-24.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        return p!=null && q!=null && isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && q.val==p.val;
    }
}
