package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/1/17.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(k==0)return head;

        int n=0;
        ListNode x=head;
        while(x!=null){
            n++;
            x=x.next;
        }
        k%=n;
        if(k==0)return head;
        int m=n-k-1;
        x=head;
        for(int i=0; i<m; i++)
            x=x.next;
        ListNode newHead=x.next;
        x.next=null;
        ListNode y=newHead;
        while(y!=null && y.next!=null)
            y=y.next;
        y.next=head;
        return newHead;

    }
}
