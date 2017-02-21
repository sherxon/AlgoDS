package interviewquestions.easy;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 12/28/16.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode x) {
        if(x==null || x.next==null)return false;
        ListNode fast=x.next.next;

        while(fast!=null && fast.next!=null && x.next!=null){
            x=x.next;
            fast=fast.next.next;
            if(x==fast)return true;
        }
        return false;
    }

}

/*

class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
* */