package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-28.
 */
public class IntersectionofTwoLinkedLists {
    /**
    * Case: Find intersection node of two linked lists.
    * This can be recursively and iteratively. Iterative solution: find size of both lists and move pointer
    * of longer lists until it reaches the node whose length is the same as shorter list.
    * Then move both pointers forward one at a time until they reach the same value. if found return it
    * else there is no intersection point. Time Complexity is O(N)
    * */

    public ListNode getIntersectionNode(ListNode x, ListNode y) {

        ListNode xHelper = x;
        ListNode yHelper = y;

        int sizeX = 0;
        int sizeY = 0;

        // get the size of each list
        while (xHelper != null || yHelper != null) {
            if (xHelper != null) {
                xHelper = xHelper.next;
                sizeX++;
            }
            if (yHelper != null) {
                yHelper = yHelper.next;
                sizeY++;
            }
        }
        xHelper = x;
        yHelper = y;

        if (sizeX > sizeY) {
            for (int i = 0; i < sizeX - sizeY; i++) xHelper = xHelper.next;
        } else if (sizeX < sizeY) {
            for (int i = 0; i < sizeY - sizeX; i++) yHelper = yHelper.next;
        }
        // find the intersection node
        while (yHelper != null && xHelper != null) {
            if (yHelper == xHelper) return xHelper;
            yHelper = yHelper.next;
            xHelper = xHelper.next;
        }

        return null;
    }

    /**
    * This is another iterative solution without knowing size of lists.
    * We can use two iterations to do that. In the first iteration, we will reset the pointer of one
    * linked list to the head of another linked list after it reaches the tail node. In the second
    * iteration, we will move two pointers until they points to the same node. Our operations in first
    * iteration will help us counteract the difference. So if two linked list intersects,
    * the meeting point in second iteration must be the intersection point. If the two linked lists
    * have no intersection at all, then the meeting pointer in second iteration must be the tail
    * node of both lists, which is null
    * */
    public ListNode getIntersectionNode2(ListNode x, ListNode y) {
        if(x==null || y==null)return null;

        ListNode xhead=x;
        ListNode yhead=y;

        while (xhead != yhead){
            xhead = xhead == null ? y : xhead.next;
            yhead = yhead == null ? x : yhead.next;
        }
        return xhead;
    }
}
