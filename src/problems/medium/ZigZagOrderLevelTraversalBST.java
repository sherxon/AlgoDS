package problems.medium;

import problems.utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sherxon on 1/8/17.
 */
@SuppressWarnings("Duplicates")
public class ZigZagOrderLevelTraversalBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new ZigZagOrderLevelTraversalBST().zigzagLevelOrder2(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> l = new LinkedList<>();
        l.add(root.val);
        list.add(l);
        LinkedList<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {

            TreeNode x = q.removeFirst();
            if (x.right != null) q.addLast(x.right);
            if (x.left != null) q.addLast(x.left);

            level--;

            if (level == 0 && !q.isEmpty()) {
                LinkedList<Integer> ll = new LinkedList<>();
                level += q.size();
                for (TreeNode xx : q) {
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

    public String zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return "";
        List<Integer> l = new LinkedList<>();
        l.add(root.val);
        list.add(l);
        LinkedList<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {

            TreeNode x = q.removeFirst();
            if (x.right != null)
                q.addLast(x.right);
            if (x.left != null)
                q.addLast(x.left);

            level--;

            if (level == 0 && !q.isEmpty()) {
                LinkedList<Integer> ll = new LinkedList<>();
                level += q.size();
                for (TreeNode xx : q) {
                    if (flag)
                        ll.addFirst(xx.val);
                    else
                        ll.addLast(xx.val);
                }
                flag = !flag;
                list.add(ll);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            List<Integer> integers = list.get(i);
            if (list.size() % 2 != 0) {
                Collections.reverse(integers);
            }
            builder.append(integers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","))
            );
            builder.append(",");
        }

        return builder.toString().substring(0, builder.length() - 1);
    }
}
