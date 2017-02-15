package interviewquestions.hard;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 2/14/17.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int ll = 1;
        System.out.println(Math.abs(2147483647 + (long) ll));
    }

    public int maxPathSum(TreeNode root) {

        if (root == null) return 0;
        find(root);
        return max;
    }

    int find(TreeNode x) {
        if (x == null) return 0;

        int left = Math.max(0, find(x.left));
        int right = Math.max(0, find(x.right));

        max = Math.max(max, left + right + x.val);
        x.val = Math.max(left, right) + x.val;
        return x.val;

    }
}
