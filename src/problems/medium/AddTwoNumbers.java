package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/1/17.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null )return l2;
        if(l2==null)return l1;
        ListNode x=new ListNode(0);
        ListNode head=x;
        int carry=0;
        while(l1!=null  || l2!=null){
            int val=0;
            if(l1==null && l2!=null)
                val=l2.val+carry;
            else if(l2==null && l1!=null)
                val=l1.val+carry;
            else
                val=l2.val+carry+l1.val;

            carry=val/10;
            x.next=new ListNode(val%10);
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            x=x.next;
        }
        if(carry>0){
            x.next=new ListNode(carry);
        }
        return head.next;

    }
}
