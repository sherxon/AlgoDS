package problems.easy;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 6/3/17.
 */
public class ConstructStringfromBinaryTree {

  public String tree2str(TreeNode t) {
    StringBuilder sb = new StringBuilder();
    if (t == null) {
      return sb.toString();
    }
    pro(t, sb);
    return sb.toString();
  }

  void pro(TreeNode x, StringBuilder sb) {
    if (x == null) {
      return;
    }

    sb.append(x.val);
    if (x.left != null) {
      sb.append("(");
      pro(x.left, sb);
      sb.append(")");
    }
    if (x.left == null && x.right != null) {
      sb.append("(");
      sb.append(")");
    }
    if (x.right != null) {
      sb.append("(");
      pro(x.right, sb);
      sb.append(")");
    }

  }

}
