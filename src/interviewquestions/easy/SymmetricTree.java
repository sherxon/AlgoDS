package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 12/30/16.
 */

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {
    //solution 1 using inverting and checking equality
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        invert(root.left);
        return checkEqual(root.left, root.right);

    }

    void invert(TreeNode x) {
        if (x == null) return;
        TreeNode temp = x.left;
        x.left = x.right;
        x.right = temp;
        invert(x.left);
        invert(x.right);
    }

    boolean checkEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        return a != null && b != null && a == b && checkEqual(a.left, b.left) && checkEqual(a.right, b.right);
    }

    /**
     * Solution 2
     */
    boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return checkSym(root.left, root.right);
    }

    private boolean checkSym(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        return left.val == right.val
                && checkSym(left.left, right.right)
                && checkEqual(left.right, right.left);
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        return it(root);
    }

    boolean it(TreeNode x) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();

        q.add(x);
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode r = q.remove();
            level--;
            if (r != null) {
                q.add(r.left);
                q.add(r.right);
                list.addFirst(r.left);
                list.addFirst(r.right);
            }

            if (level == 0 && !q.isEmpty()) {
                level += q.size();
                Iterator<TreeNode> itq = q.iterator();
                Iterator<TreeNode> itl = list.iterator();
                if (q.size() != list.size()) return false;
                while (itq.hasNext()) {
                    TreeNode le = itq.next();
                    TreeNode ri = itl.next();
                    if (le == null && ri != null) return false;
                    if (ri == null && le != null) return false;
                    if (le != null && ri != null && le.val != ri.val) return false;
                }
                list.clear();
            }
        }
        return true;
    }
}
