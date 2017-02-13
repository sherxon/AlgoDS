package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 2/12/17.
 */

/**
 * Find Largest Element in Each Row of Binary Tree
 */
public class LargetElementinRowsBT {
    public int[] largestValues(TreeNode root) {
        return findValueMostElement(root);
    }

    /**
     * I traversed level order and find max in each row .
     */
    public int[] findValueMostElement(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        int level = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        res.add(root.val);
        while (!list.isEmpty()) {
            TreeNode x = list.removeFirst();
            level--;
            if (x.left != null) list.addLast(x.left);
            if (x.right != null) list.addLast(x.right);
            if (level == 0 && !list.isEmpty()) {
                int max = Integer.MIN_VALUE;
                for (TreeNode treeNode : list) {
                    max = Math.max(treeNode.val, max);
                    level++;
                }
                res.add(max);
            }
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}
