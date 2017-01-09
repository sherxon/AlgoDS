package interviewquestions.easy;

import interviewquestions.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class ReverseLinkedList {
    /**
     * Case:  Reverse Linked list in one pass without extra space.
     * This can be solved recursively and iteratively. Iterative solution is given below.
     * We get each node in iteration and set previous node of this node as next node.
     *Time complexity is O(N)
    * */


    public ListNode reverseList(ListNode root) {

        ListNode newHead = null;
        ListNode nextNode = null;

        while (root != null) {
            nextNode = root.next;
            root.next = newHead;
            newHead = root;
            root = nextNode;
        }

        return newHead;
    }
}
