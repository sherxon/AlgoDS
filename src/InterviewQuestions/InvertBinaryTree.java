package InterviewQuestions;

/**
 * Created by sherxon on 12/24/16.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public void swap(TreeNode x){
        TreeNode temp=x.left;
        x.left=x.right;
        x.right=temp;
    }
}
