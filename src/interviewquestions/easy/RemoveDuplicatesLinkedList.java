package interviewquestions.easy;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 12/28/16.
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
