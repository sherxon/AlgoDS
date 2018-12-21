package problems.easy;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode x, TreeNode y) {
        if (x == null || y == null)
            return x == y;

        List<Integer> l = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(x, l);
        dfs(y, l2);

        if (l.size() != l2.size())
            return false;

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != l2.get(i))
                return false;
        }
        return true;
    }

    void dfs(TreeNode x, List<Integer> list) {
        if (x == null)
            return;
        if (x.left == null && x.right == null) {
            list.add(x.val);
            return;
        }
        dfs(x.left, list);
        dfs(x.right, list);
    }
}
