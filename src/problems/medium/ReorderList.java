package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/8/17.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head==null)return;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null; // break the link

        // reverse the right
        ListNode newHead = right;
        while (right != null && right.next != null) {
            ListNode temp = right.next;
            right.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }
        // merge two lists
        ListNode xx = head;
        while (xx != null) {
            ListNode temp = xx.next;
            xx.next = newHead;
            if (newHead != null) {
                newHead = newHead.next;
                xx.next.next = temp;
            }

            xx = temp;
        }
    }

}

