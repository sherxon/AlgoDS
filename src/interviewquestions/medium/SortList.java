package interviewquestions.medium;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 1/8/17.
 */
public class SortList {
    /**
    * This is mergeSort algorithm for linked list. It divides list into two halves using two (slow, fast)
    * pointer and sort each half.
    * */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) { // slow in middle element
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode start2 = slow.next;
        slow.next = null; // break the link

        ListNode start1 = sortList(head); // sort first half
        ListNode start11 = sortList(start2); // sort second half

        return merge(start1, start11); // merge sorted arrays
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode root = new ListNode(0); // helper node
        ListNode x = root;
        while (a != null || b != null) {
            if (a == null) {
                x.next = b;
                b = b.next;
            } else if (b == null) {
                x.next = a;
                a = a.next;
            } else if (a.val <= b.val) {
                x.next = a;
                a = a.next;
            } else {
                x.next = b;
                b = b.next;
            }
            x = x.next;
        }
        return root.next;
    }
}
