package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-31.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return null;
        if(head.next==null || head.next.next==null)return head;

        ListNode x=head;
        ListNode evenHead=null;
        ListNode even=null;
        while(x!=null){
            if(even==null){
                even=x.next;
                evenHead=even;
            }else{
                even.next=x.next;
                even=even.next;
            }
            if(x.next!=null){
                x.next=x.next.next;
            }
            if(x.next==null){
                x.next=evenHead;
                break;
            }

            x=x.next;

        }
        return head;
    }
}
