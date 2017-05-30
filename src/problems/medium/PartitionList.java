package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/16/17.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        while (temp != null && temp.val < x) {
            dummy.next = temp;
            dummy = dummy.next;
            temp = temp.next;
        }
        ListNode prev = temp;
        while (temp != null && temp.next != null) {
            if (temp.next.val < x) {
                dummy.next = temp.next;
                dummy = dummy.next;
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        dummy.next = prev;
        return dummyHead.next;
    }
}
