package InterviewQuestions.Easy;

import InterviewQuestions.ListNode;

/**
 * Created by sherxon on 12/24/16.
 */
public class DeleteNodeSingleLinkedList {
    /**
     * Case: We have only list node which is not last element. To remove this node, we can chnage its value
     * and set pointer to next of next.
     */
    public void deleteNode(ListNode x) {
        if (x == null) return;
        x.val = x.next.val;
        x.next = x.next.next;
    }
}
