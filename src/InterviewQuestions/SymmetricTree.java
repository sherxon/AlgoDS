package InterviewQuestions;

/**
 * Created by sherxon on 12/30/16.
 */
public class SymmetricTree {
    //solution one using inverting and checking equality
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        invert(root.left);
        return checkEqual(root.left, root.right);

    }
    void invert(TreeNode x){
        if(x==null)return;
        TreeNode temp=x.left;
        x.left=x.right;
        x.right=temp;
        invert(x.left);
        invert(x.right);
    }
    boolean checkEqual(TreeNode a, TreeNode b){
        if(a==null && b==null)return true;
        return a!=null && b!=null && a==b && checkEqual(a.left, b.left) && checkEqual(a.right, b.right);
    }
    // second solution

    boolean isSymmetric2(TreeNode root){
        if(root==null)return true;
        return checkSym(root.left, root.right);
    }

    private boolean checkSym(TreeNode left, TreeNode right) {
        if(left==null || right==null )return left==right;
        return  left.val==right.val
                && checkSym(left.left, right.right)
                && checkEqual(left.right, right.left);
    }
}
