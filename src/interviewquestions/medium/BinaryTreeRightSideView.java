package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 1/9/17.
 */
public class BinaryTreeRightSideView {
    /**
     * Solution 1:
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        q.add(root);
        level.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        while (!q.isEmpty()) {
            TreeNode x = q.removeFirst();

            if (x.left != null)
                q.add(x.left);
            if (x.right != null)
                q.add(x.right);
            level.removeFirst();
            if (level.isEmpty() && !q.isEmpty()) {
                for (TreeNode n : q)
                    level.add(n);
                list.add(level.getLast().val);
            }

        }

        return list;
    }

    /**
     * Solution 2
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
