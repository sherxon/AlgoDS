package contests.contest36;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 6/10/17.
 */
public class MergeTwoBinaryTrees {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode root = new TreeNode(t1.val + t2.val);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t2.left, t1.right);
    return root;
  }

}
