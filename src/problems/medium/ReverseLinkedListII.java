package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/8/17.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m==n)return head;
        ListNode mm=null;
        ListNode nn=null;
        ListNode x=head;
        ListNode prevofm=null;
        for(int i=1; ; i++){
            if(i==m-1)prevofm=x;
            if(i==m)mm=x;
            if(i==n)nn=x;
            if(nn!=null && mm!=null)break;
            x=x.next;
        }

        ListNode nextofn=nn.next;
        nn.next=null;
        mm=reverse(mm);
        if(prevofm!=null)prevofm.next=nn;
        mm.next=nextofn;

        if(m==1)head=nn;
        return head;
    }
    ListNode reverse(ListNode x){
        if(x==null)return null;
        if(x.next==null)return x;
        ListNode q=reverse(x.next);
        q.next=x;
        return x;
    }
}
