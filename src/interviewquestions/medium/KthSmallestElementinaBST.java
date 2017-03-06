package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/6/17.
 */
public class KthSmallestElementinaBST {
    /**
     * This is iterative solution with O(N) space and O(N) time.
     * get kth element from inorder traversal of Binary search tree.
     */

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();

        inOrder(root, list);

        return list.get(k - 1);
    }

    void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);

        list.add(root.val);

        inOrder(root.right, list);
    }

    /**
     * Recursive Binary Search method. Time complexity is little higher than previous one but This does not use
     * any extra memory. We can use O(N) space in order to keep size of all nodes to make DP solution.
     */
    public int kthSmallest2(TreeNode root, int k) {
        int count = nodeCount(root);

        if (k < count)
            return kthSmallest2(root.left, k);

         else if (k > count + 1)
            return kthSmallest2(root.right, k - 1 - count); // 1 is current node

        return root.val;
    }

    private int nodeCount(TreeNode root) {

        if (root == null) return 0;

        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
}
