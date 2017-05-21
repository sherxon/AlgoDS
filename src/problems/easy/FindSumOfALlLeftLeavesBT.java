package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 5/21/17.
 */
public class FindSumOfALlLeftLeavesBT {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return sum(root, root);
  }

  private int sum(TreeNode root, TreeNode child) {
    if (child == null) {
      return 0;
    }
    if (child.left == null && child.right == null && child == root.left) {
      return child.val;
    }
    return sum(child, child.left) + sum(child, child.right);

  }
}
