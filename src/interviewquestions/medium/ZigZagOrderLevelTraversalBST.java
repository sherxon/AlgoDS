package interviewquestions.medium;

import interviewquestions.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 1/8/17.
 */
public class ZigZagOrderLevelTraversalBST {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> l = new LinkedList<>();
        l.add(root.val);
        list.add(l);
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        q.add(root);
        level.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {

            TreeNode x = q.removeFirst();
            if (x.right != null) q.addLast(x.right);
            if (x.left != null) q.addLast(x.left);

            level.removeFirst();

            if (level.isEmpty() && !q.isEmpty()) {
                LinkedList<Integer> ll = new LinkedList<>();

                for (TreeNode xx : q) {
                    level.add(xx);
                    if (flag)
                        ll.addFirst(xx.val);
                    else
                        ll.addLast(xx.val);
                }
                flag = !flag;
                list.add(ll);
            }

        }
        return list;
    }
}
