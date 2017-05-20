package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-24.
 */
public class DeleteNodeSingleLinkedList {
    /**
     * Case: We have only list node which is not last element. To remove this node, we can change its value
     * and set pointer to next of next.
     */
    public void deleteNode(ListNode x) {
        if (x == null) return;
        x.val = x.next.val;
        x.next = x.next.next;
    }
}
