package InterviewQuestions.Easy;


/**
 * Created by sherxon on 12/24/16.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;

        int left=minDepth(root.left);
        int right=minDepth(root.right);

        if(left==0 || right==0)
            return Math.max(left,right)+1;
        else
            return Math.min(left,right)+1;
    }
}
