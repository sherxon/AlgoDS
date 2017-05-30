package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 2016-12-31.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode x=head.next;
        while(x!=null){
            sort(head, x);
            x=x.next;
        }
        return head;
    }
    void sort(ListNode head, ListNode x){
        if(head==x)return;
        sort(head.next, x);
        if(head.val>head.next.val)
            swap(head, head.next);
    }
    void swap(ListNode a, ListNode b){
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
}
