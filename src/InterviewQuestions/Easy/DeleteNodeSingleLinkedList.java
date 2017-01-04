package InterviewQuestions.Easy;

import InterviewQuestions.ListNode;

/**
 * Created by sherxon on 12/24/16.
 */
public class DeleteNodeSingleLinkedList {

    public void deleteNode(ListNode x) {
        x.val=x.next.val;
        x.next=x.next.next;
    }
}
