package problems.easy;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-28.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode x=null;
        if(l1.val<l2.val){
            ListNode listNode= new ListNode(l1.val);
            x=listNode;
            l1=l1.next;
        }else{
            ListNode listNode= new ListNode(l2.val);
            x=listNode;
            l2=l2.next;
        }
        ListNode head=x;
        while (l1!=null || l2!=null){
            if(l1==null || (l2!=null && l2.val<l1.val)){
                ListNode listNode= new ListNode(l2.val);
                x.next=listNode;
                x=listNode;
                l2=l2.next;
            }else if(l2==null || (l1!=null && l1.val<=l2.val)){
                ListNode listNode= new ListNode(l1.val);
                x.next=listNode;
                x=listNode;
                l1=l1.next;
            }
        }
        return x;
    }
}
