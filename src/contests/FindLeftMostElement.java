package contests;

import interviewquestions.utils.TreeNode;

import java.util.TreeMap;

/**
 * Created by sherxon on 2/11/17.
 */
public class FindLeftMostElement {
    public int findLeftMostNode(TreeNode root) {
        if (root == null) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b.compareTo(a));
        find(root, 0, map);
        return map.values().iterator().next();
    }

    //[0,null,-1]
    private void find(TreeNode root, int i, TreeMap<Integer, Integer> map) {
        if (root == null) return;
        if (!map.containsKey(i))
            map.put(i, root.val);
        if (root.left != null)
            find(root.left, i + 1, map);
        if (root.right != null)
            find(root.right, i + 1, map);
    }
}
