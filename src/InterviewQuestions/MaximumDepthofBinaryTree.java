package InterviewQuestions;

/**
 * Created by sherxon on 12/24/16.
 */
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {

    }


    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }


}
