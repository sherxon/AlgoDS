package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 12/25/16.
 */
public class PathSum {
    boolean r=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        f(root, sum, 0);
        return r;
    }

    void f(TreeNode x, int s, int p){
        if(x==null)return;
        x.val+=p;
        f(x.left, s, x.val);
        f(x.right, s, x.val);
        if(x.left==null && x.right==null && x.val==s)r=true;

    }
}
