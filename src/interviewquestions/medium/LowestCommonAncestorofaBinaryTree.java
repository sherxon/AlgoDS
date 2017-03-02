package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.*;

/**
 * Created by sherxon on 3/2/17.
 */
public class LowestCommonAncestorofaBinaryTree {
    /**
     * We first find path from root to p and from root to q nodes.
     * Then we traverse both paths till the values in arrays are same.
     * Return the common element just before the mismatch.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Map<TreeNode, TreeNode> map = bfs(root);
        LinkedList<TreeNode> pPath = new LinkedList<>();
        TreeNode pp = p;
        while (pp != null) {
            pPath.addFirst(pp);
            pp = map.get(pp);
        }
        LinkedList<TreeNode> qPath = new LinkedList<>();
        TreeNode qq = q;
        while (qq != null) {
            qPath.addFirst(qq);
            qq = map.get(qq);
        }
        ListIterator<TreeNode> pit = pPath.listIterator();
        ListIterator<TreeNode> qit = qPath.listIterator();
        while (pit.hasNext() || qit.hasNext()) {
            if (!pit.hasNext()) return pit.previous();
            if (!qit.hasNext()) return qit.previous();
            TreeNode pcurrent = pit.next();
            TreeNode qcurrent = qit.next();

            if (pcurrent != qcurrent) return map.get(pcurrent);
        }
        return root;
    }

    Map<TreeNode, TreeNode> bfs(TreeNode x) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(x);
        int l = 1;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(x, null);
        while (!q.isEmpty()) {
            TreeNode xx = q.remove();
            l--;
            if (xx.left != null) {
                q.add(xx.left);
                map.put(xx.left, xx);
            }
            if (xx.right != null) {
                q.add(xx.right);
                map.put(xx.right, xx);
            }
            if (l == 0) l += q.size();
        }
        return map;
    }

}
