package problems.medium;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 2016-12-30.
 */
public class SumRoottoLeafNumbers {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        sum(root, 0);
        return sum;
    }
    public void sum(TreeNode x, int p){
        if(x==null) return;
        x.val=x.val+p;
        sum(x.left, x.val*10);
        sum(x.right, x.val*10);
        if(x.left==null && x.right==null)sum+=x.val;
    }
}
