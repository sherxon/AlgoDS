package interviewquestions.medium;

import interviewquestions.utils.ListNode;
import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 1/5/17.
 */

public class ConvertSortedListtoBinarySearchTree {
    /**
     * Divide List recursively into two parts by finding middle with two pointers, then do merge
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev != null) prev.next = null; // break the link
        else head = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
