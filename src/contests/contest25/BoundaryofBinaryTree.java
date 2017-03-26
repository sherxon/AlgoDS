package contests.contest25;

import interviewquestions.utils.TreeNode;

import java.util.*;

/**
 * Created by sherxon on 3/25/17.
 */
public class BoundaryofBinaryTree {
    public static void main(String[] args) {

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        if (root.left == null && root.right == null) return list;
        Set<TreeNode> set = new HashSet<>();
        LinkedList<TreeNode> leftView = new LinkedList<>();

        goLeft(root.left, leftView, 0);
        Iterator<TreeNode> itleft = leftView.iterator();
        while (itleft.hasNext()) {
            TreeNode cur = itleft.next();
            if (!set.contains(cur)) {
                set.add(cur);
                list.add(cur.val);
            }
        }

        getLeaves(root, list, set);

        LinkedList<TreeNode> rightView = new LinkedList<>();
        goRight(root.right, rightView, 0);
        Iterator<TreeNode> itright = rightView.iterator();
        while (itright.hasNext()) {
            TreeNode cur = itright.next();
            if (!set.contains(cur)) {
                set.add(cur);
                list.add(cur.val);
            }
        }


        return list;
    }

    private void goRight(TreeNode root, LinkedList<TreeNode> list, int level) {
        if (root == null) return;
        if (list.size() == level) list.addFirst(root);
        goRight(root.right, list, level + 1);
        goRight(root.left, list, level + 1);
    }

    private void getLeaves(TreeNode root, List<Integer> list, Set<TreeNode> set) {
        if (root == null) return;
        if (root.left == null && root.right == null && !set.contains(root)) {
            list.add(root.val);
            set.add(root);
        }
        getLeaves(root.left, list, set);
        getLeaves(root.right, list, set);
    }

    private void goLeft(TreeNode root, LinkedList<TreeNode> list, int level) {

        if (root == null) return;
        if (level == list.size()) list.add(root);
        goLeft(root.left, list, level + 1);
        goLeft(root.right, list, level + 1);
    }
}
