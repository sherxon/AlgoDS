package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 2/11/17.
 */

/**
 *
 * */
public class FindLargestElementinEachRow {
    public static void main(String[] args) {

    }

    public int[] findValueMostElement(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> level = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        level.add(root.val);
        list.add(root);
        res.add(root.val);
        while (!list.isEmpty()) {
            TreeNode x = list.removeFirst();
            level.removeFirst();
            if (x.left != null) list.addLast(x.left);
            if (x.right != null) list.addLast(x.right);
            if (level.isEmpty() && !list.isEmpty()) {
                int max = Integer.MIN_VALUE;
                for (TreeNode treeNode : list) {
                    max = Math.max(treeNode.val, max);
                    level.add(treeNode.val);
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
