package interviewquestions.easy;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class ReverseLinkedList {
    /**
     * This is recursive solution
     */
    ListNode newHead;

    /**
     * Case:  Reverse Linked list in one pass without extra space.
     * This can be solved recursively and iteratively. Iterative solution is given below.
     * We get each node in iteration and set previous node of this node as next node.
     *Time complexity is O(N)
    * */


    public ListNode reverseList(ListNode root) {

        ListNode newHead = null;

        while (root != null) {
            ListNode nextNode = root.next;
            root.next = newHead;
            newHead = root;
            root = nextNode;
        }

        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        reverse(head);
        head.next = null;
        return newHead;
    }

    ListNode reverse(ListNode current) {
        if (current == null || current.next == null) {
            newHead = current;
            return current;
        }
        ListNode prev = reverse(current.next);
        prev.next = current;
        return current;
    }
}
