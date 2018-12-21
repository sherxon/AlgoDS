package problems.easy;

import problems.utils.ListNode;

/**
 * Why Did you create this class? what does it do?
 */
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode x) {
        if (x == null || x.next == null)
            return x;
        int c = 0;
        ListNode y = x;
        while (y != null) {
            c++;
            y = y.next;
        }
        int mid = c / 2;
        int i = 0;
        while (i < mid) {
            i++;
            x = x.next;
        }
        return x;

    }
}
