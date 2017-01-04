package InterviewQuestions.Medium;

import InterviewQuestions.TreeNode;

import java.util.Stack;

/**
 * Created by sherxon on 1/4/17.
 */
public class BinarySearchTreeIterator {
    TreeNode root= new TreeNode(-1);
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        this.root.left=root;
        this.stack=new Stack<>();
        TreeNode x=this.root;
        while(x!=null){
            stack.add(x);
            x=x.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>1;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode r= stack.pop();
        if(stack.size()>0){
            TreeNode peek=stack.peek();
            peek.left=r.right;
            TreeNode temp=peek.left;
            while(temp!=null){
                stack.add(temp);
                temp=temp.left;
            }
        }

        return r.val;
    }
}
