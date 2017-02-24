package interviewquestions.easy;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 12/28/16.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(0);
        ListNode listNode1 = insertionSortList(listNode);
    }

    static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode x = head;
        while (x != null) {
            ListNode h = temp.next;
            while (h.val < x.val && h != x) {
                h = h.next;
            }
            ListNode te = h.next;
            h.next = x;
            x.next = te;
            x = x.next;
        }
        return temp.next;
    }

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