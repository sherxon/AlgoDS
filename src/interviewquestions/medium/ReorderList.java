package interviewquestions.medium;

import interviewquestions.utils.ListNode;

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
        ListNode nh = right;
        while (right != null && right.next != null) {
            ListNode temp = right.next;
            right.next = temp.next;
            temp.next = nh;
            nh = temp;
        }

        ListNode xx = head;
        while (xx != null) {
            ListNode temp = xx.next;
            xx.next = nh;
            if (nh != null) {
                nh = nh.next;
                xx.next.next = temp;
            }

            xx = temp;
        }
    }

}

