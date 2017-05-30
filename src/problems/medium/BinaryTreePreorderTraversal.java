package problems.medium;

import problems.utils.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by sherxon on 1/3/17.
 */
public class BinaryTreePreorderTraversal {
    private void preOrderIterative(TreeNode x, List<Integer> list) {
        Stack<TreeNode> stack=new Stack<>();
        stack.add(x);
        while (!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            list.add(treeNode.val);
            if(treeNode.right!=null)
                stack.add(treeNode.right);
            if(treeNode.left!=null)
                stack.add(treeNode.left);
        }
    }
}
