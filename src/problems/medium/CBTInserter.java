package problems.medium;

import problems.utils.TreeNode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class CBTInserter {

    TreeNode root;
    int level = 0;
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        pop(root);
    }

    void pop(TreeNode x) {
        int l = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(x);
        List<TreeNode> list = new ArrayList<>(q);
        map.put(1, list);
        level = 1;
        while (!q.isEmpty()) {
            l--;
            TreeNode c = q.remove();
            if (c.left != null)
                q.add(c.left);
            if (c.right != null)
                q.add(c.right);
            if (l == 0 && q.size() > 0) {
                l += q.size();
                map.put(++level, new ArrayList<>(q));
            }
        }
    }

    public int insert(int v) {
        TreeNode nn = new TreeNode(v);
        int levelSize = map.get(level).size();
        if (levelSize == (int) Math.pow(2, level - 1)) {
            TreeNode parent = map.get(level).get(0);
            parent.left = nn;
            level++;
            map.put(level, new ArrayList<>());
            map.get(level).add(nn);
            return parent.val;
        } else {
            int sz = map.get(level).size();
            TreeNode parent = map.get(level - 1).get(sz / 2);
            if (parent.left == null)
                parent.left = nn;
            else
                parent.right = nn;
            map.get(level).add(nn);
            return parent.val;
        }
    }

    public TreeNode get_root() {
        return root;
    }
}
