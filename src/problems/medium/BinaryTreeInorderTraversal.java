package problems.medium;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sherxon on 1/3/17.
 */
// recursive and iterative solutions
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
//        inOrder(root, list);
        inOrderIterative(root, list);
        return list;
    }

    private void inOrderIterative(TreeNode x, List<Integer> list) {
        Stack<TreeNode> stack=new Stack<>();

        while (x!=null || !stack.isEmpty()){
            while(x!=null){
                stack.add(x);
                x=x.left;
            }
            x=stack.pop();
            list.add(x.val);
            x=x.right;
        }
    }

    void inOrder(TreeNode x, List<Integer> list){
        if(x==null)return;
        inOrder(x.left, list);
        list.add(x.val);
        inOrder(x.right,list);
    }
}
