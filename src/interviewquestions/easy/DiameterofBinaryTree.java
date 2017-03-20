package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 3/19/17.
 */
public class DiameterofBinaryTree {
    Map<TreeNode, Integer> map = new HashMap<>();
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int hl = height(root.left);
        int hr = height(root.right);
        max = Math.max(hl + hr + 2, max);
        if (hl > hr)
            diameterOfBinaryTree(root.left);
        else if (hl < hr)
            diameterOfBinaryTree(root.right);
        return max;
    }

    int height(TreeNode x) {
        if (x == null) return -1;
        int left = map.getOrDefault(x.left, height(x.left));
        int right = map.getOrDefault(x.right, height(x.right));
        map.put(x, Math.max(left, right) + 1);
        return map.get(x);
    }
}
