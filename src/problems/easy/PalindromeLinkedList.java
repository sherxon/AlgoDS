package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-29.
 */

public class PalindromeLinkedList {
    /**
     * Can you find out if the list is palindrome ? Can you do it without reversing list?
     * The obvious solution is reversing list in O(N) and compare each element of reversed list with
     * original list. If palindrome , each node will be equal else not.
     * */

    ListNode rightStart = null;
    /**
    * Bottom-Up Recursive solution. First We find length of list and find middle node.
    * Then we will compare last element of right half with the first element of left part in
    * in bottom up recursion. Time complexity is O(n) to find size and O(N) to compare left and right
    * lists.
    * */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int size = 0;
        ListNode x = head;
        while (x != null) {
            size++;
            x = x.next;
        }
        int start;
        if (size % 2 == 0) start = size / 2 + 1;
        else start = size / 2 + 2;

        rightStart = head;
        for (int i = 1; i < start; i++) rightStart = rightStart.next;

        return checkTwoHalves(head, size / 2);
    }

    boolean checkTwoHalves(ListNode x, int size) {
        if (size == 1) return x.val == rightStart.val;
        boolean b = checkTwoHalves(x.next, size - 1);
        rightStart = rightStart.next;
        return b && x.val == rightStart.val;
    }
}
