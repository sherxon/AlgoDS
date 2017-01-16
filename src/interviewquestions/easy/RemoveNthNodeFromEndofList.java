package interviewquestions.easy;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode h, int nu) {
        int size=0;
        ListNode head=h;
        while(head!=null){
            head=head.next;
            size++;
        }
        int i=0;
        ListNode n=h;
        ListNode p=h;
        while(i<size-nu){
            i++;
            p=n;
            n=n.next;
        }
        if(i==0){
            if(p.next==null)return null;
            else h=p.next;
        }
        p.next=n.next;
        return h;

    }
}
