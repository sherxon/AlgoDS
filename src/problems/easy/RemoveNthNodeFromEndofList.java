package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class RemoveNthNodeFromEndofList {
    /**
     * This is the recursive approach
     */

    int n = 0;

    public ListNode removeNthFromEnd(ListNode h, int nu) {
        int size = 0;
        ListNode head = h;
        while (head != null) {
            head = head.next;
            size++;
        }
        int i = 0;
        ListNode n = h;
        ListNode p = h;
        while (i < size - nu) {
            i++;
            p = n;
            n = n.next;
        }
        if (i == 0) {
            if (p.next == null) return null;
            else h = p.next;
        }
        p.next = n.next;
        return h;

    }

    public ListNode removeNthFromEndR(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        this.n = n;
        remove(head);
        return this.n == 0 ? head.next : head;
    }

    void remove(ListNode x) {
        if (x == null) return;
        remove(x.next);
        if (n == 0) {
            x.next = x.next.next;
        }
        n--;

    }
}
