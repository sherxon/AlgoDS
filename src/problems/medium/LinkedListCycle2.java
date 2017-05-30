package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/14/17.
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;// break the link
        ListNode link = findLink(head, temp);
        slow.next = temp; // link the break
        return link;
    }

    ListNode findLink(ListNode x, ListNode y) {
        if (x == null || y == null) return null;

        ListNode xhead = x;
        ListNode yhead = y;

        while (xhead != yhead) {
            xhead = xhead == null ? y : xhead.next;
            yhead = yhead == null ? x : yhead.next;
        }
        return xhead;
    }
}
