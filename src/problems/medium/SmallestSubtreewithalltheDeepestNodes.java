package problems.medium;

import problems.utils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return root;
        Set<TreeNode> set = new HashSet<>();
        findDeepNodes(set, root);
        return getParentOfDeepNodes(set, root);
    }

    TreeNode getParentOfDeepNodes(Set<TreeNode> set, TreeNode x) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(x);
        TreeNode r = x;
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            if (!isParent(current, new HashSet<>(set))) {
                continue;
            }
            r = current;
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
        }
        return r;
    }

    boolean isParent(TreeNode x, Set<TreeNode> set) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            set.remove(current);
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);

        }
        return set.isEmpty();
    }

    void findDeepNodes(Set<TreeNode> set, TreeNode x) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(x);
        int count = 1;
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            count--;
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
            if (count == 0) {
                count += q.size();
                if (q.size() > 0) {
                    set.clear();
                    set.addAll(q);
                }
            }
        }

    }

}
