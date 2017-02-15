package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by sherxon on 12/24/16.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        list.add(l);
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode x = q.remove();
            level--;
            if (x.left != null) q.add(x.left);
            if (x.right != null) q.add(x.right);

            if (level == 0 && !q.isEmpty()) {
                l = new ArrayList<>();
                for (TreeNode tr : q) {
                    level++;
                    l.add(tr.val);
                }
                list.add(l);
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> l = new LinkedList<>();
        if (root == null) return l;

        Queue<TreeNode> level = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();

        qq.add(root);
        level.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        l.add(temp);
        while (!qq.isEmpty()) {
            TreeNode t = qq.remove();
            level.remove();

            if (t.left != null) qq.add(t.left);
            if (t.right != null) qq.add(t.right);

            if (level.isEmpty() && !qq.isEmpty()) {
                List<Integer> lev = qq.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
                l.add(lev);
                level.addAll(new LinkedList<>(qq));
            }
        }
        return l;
    }

    void levelOrder2(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            if (x.left != null)
                q.add(x.left);
            if (x.right != null)
                q.add(x.right);
        }
    }
}
