package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/7/17.
 */
public class SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddP = odd;
        ListNode evenP = even;
        ListNode x = head;
        while (x != null) {
            oddP.next = x;
            oddP = oddP.next;
            x = x.next;
            if (x != null) {
                evenP.next = x;
                evenP = evenP.next;
                x = x.next;
            }
        }
        oddP.next = null;
        evenP.next = null;
        ListNode r = new ListNode(0);
        x = r;
        odd = odd.next;
        even = even.next;
        while (odd != null || even != null) {
            if (even != null) {
                x.next = even;
                even = even.next;
                x = x.next;
            }
            if (odd != null) {
                x.next = odd;
                odd = odd.next;
                x = x.next;
            }


        }
        return r.next;

    }
}
