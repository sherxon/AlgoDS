package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */
public class ValidateBinarySearchTree {

    /**
     * Solution 1:
     * solution one building valid bst from preorder traversal of input tree and check if they are the same
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> prOrder = new ArrayList<>(); // hashset is more appropriate actually
        dfs(root, prOrder);
        TreeNode x = null;
        for (Integer i : prOrder)
            x = insert(x, i);
        return isTheSameTree(x, root);
    }

    boolean isTheSameTree(TreeNode x, TreeNode root) {
        if (x == null || root == null) return x == root;
        return x.val == root.val && isTheSameTree(x.left, root.left) && isTheSameTree(x.right, root.right);
    }

    TreeNode insert(TreeNode x, int val) {
        if (x == null) return new TreeNode(val);
        if (x.val < val)
            x.right = insert(x.right, val);
        else if (x.val > val)
            x.left = insert(x.left, val);
        return x;
    }

    void dfs(TreeNode x, List<Integer> list) {
        if (x == null) return;
        list.add(x.val);
        dfs(x.left, list);
        dfs(x.right, list);
    }

    /**
     * Solution 2
     * Basically what I am doing is recursively iterating over the tree while defining interval <minVal, maxVal> for each node which value must fit in.
     * */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
