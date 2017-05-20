package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 1/19/17.
 */
public class PathSum3 {
    int counter = 0;

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(7);
        head.right.right = new TreeNode(3);
        System.out.println(new PathSum3().pathSum(head, 3));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        find(root, 0, sum);
        return counter;
    }

    void find(TreeNode x, int sum, int totalSum) {
        if (x == null) return;
        find2(x, sum, totalSum);
        find(x.left, 0, totalSum);
        find(x.right, 0, totalSum);
    }

    void find2(TreeNode x, int sum, int totalSum) {
        if (x == null) return;
        sum += x.val;
        if (sum == totalSum)
            counter++;
        find2(x.left, sum, totalSum);
        find2(x.right, sum, totalSum);
    }
}
