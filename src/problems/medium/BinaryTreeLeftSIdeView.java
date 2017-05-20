package problems.medium;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/22/17.
 */
public class BinaryTreeLeftSIdeView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        findRec(root, list, 0);
        return list;
    }

    private void findRec(TreeNode root, List<Integer> list, int i) {
        if (root == null) return;
        if (list.size() == i) list.add(root.val);
        findRec(root.left, list, i + 1);
        findRec(root.right, list, i + 1);
    }
}
