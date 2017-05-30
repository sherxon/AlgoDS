package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-28.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
        ListNode x=head;

        while(x.next!=null){
            if(x.next.val==val)
                x.next=x.next.next;
            else
                x=x.next;
        }
        return  head.val==val ? head.next : head;
    }
}
