package problems.medium;

import problems.utils.TreeNode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.left.val == root.val)
            left++;
        else
            left = 0;
        if (root.right != null && root.right.val == root.val)
            right++;
        else
            right = 0;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

}
