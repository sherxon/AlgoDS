package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 3/19/17.
 */
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        f(root, 0);
        return root;
    }

    int f(TreeNode root, int val) {
        if (root == null) return val;
        int r = f(root.right, val);
        root.val = r + root.val;
        return f(root.left, root.val);
    }
}
