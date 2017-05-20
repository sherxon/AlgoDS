package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-31.
 */
public class RemoveDuplicatesFromList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode a=new ListNode(0);
        ListNode root=a;
        ListNode x=head;
        while(x!=null){
            ListNode y=x;
            while(y!=null &&  y.val==x.val)y=y.next;
            if(x.next==y){
                ListNode temp=new ListNode(x.val);
                a.next=temp;
                a=temp;
            }
            x=y;
        }
        return root.next;
    }
}
