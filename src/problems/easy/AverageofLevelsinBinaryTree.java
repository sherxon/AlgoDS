package problems.easy;

import problems.utils.TreeNode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Double> list = new ArrayList<>();
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        double sum = 0d;
        int prevLevel = 1;
        while (!q.isEmpty()) {
            TreeNode c = q.remove();
            sum += c.val;
            level--;
            if (c.left != null)
                q.add(c.left);
            if (c.right != null)
                q.add(c.right);

            if (level == 0) {
                level += q.size();
                list.add(sum / prevLevel);
                sum = 0d;
                prevLevel = level;
            }

        }
        return list;
    }

}
