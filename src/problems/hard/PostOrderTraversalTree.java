package problems.hard;

import problems.utils.TreeNode;

import java.util.*;

/**
 * Created by sherxon on 1/3/17.
 */
public class PostOrderTraversalTree {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if(root==null)return list;
        postOrderIt(root, list);
        return list;
    }
    void postOrderRe(TreeNode x, List<Integer> list){
        if(x==null)return;
        if(x.left!=null)
            postOrderRe(x.left, list);
        if(x.right!=null)
            postOrderRe(x.right, list);
        list.add(x.val);
    }
    void postOrderIt(TreeNode root, List<Integer> list){
        Set<TreeNode> set= new HashSet<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        set.add(null);
        while(!stack.isEmpty()){
            TreeNode peek=stack.peek();
            if( (set.contains(peek.left) && set.contains(peek.right))){
                list.add(stack.pop().val);
                set.add(peek);
            }else{
                if(peek.right!=null)
                    stack.add(peek.right);
                if(peek.left!=null)
                    stack.add(peek.left);
            }
        }
    }

}

/*
* Best Solution:
Create an empty stack, Push root node to the stack.
Do following while stack is not empty.
2.1. pop an item from the stack and print it.

2.2. push the left child of popped item to stack.

2.3. push the right child of popped item to stack.

reverse the output.

* */
