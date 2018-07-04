package problems.medium;

import problems.utils.TreeNode;

import java.util.Stack;

/**
 * Created by sherxon on 1/4/17.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        add(root);

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size() > 1;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode pop = stack.pop();
        add(pop.right);
        return pop.val;
    }

    void add(TreeNode x) {
        while (x != null) {
            stack.add(x);
            x = x.left;
        }
    }

}
