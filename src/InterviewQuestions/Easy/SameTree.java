package InterviewQuestions.Easy;

import InterviewQuestions.TreeNode;

/**
 * Created by sherxon on 12/24/16.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        return p!=null && q!=null && isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && q.val==p.val;
    }
}
