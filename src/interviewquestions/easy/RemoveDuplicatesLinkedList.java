package interviewquestions.easy;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 12/28/16.
 */

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.->3
 */
public class RemoveDuplicatesLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode x=head;
        while(x!=null){
            if(x.next!=null && x.val==x.next.val){
                x.next=x.next.next;
            }else{
                x=x.next;
            }
        }
        return head;
    }
}
