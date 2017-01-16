package interviewquestions.medium;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] a) {
        if(a==null || a.length==0)return null;
        if(a.length==1)return a[0];
        return merge(a, 0, a.length-1);

    }
    ListNode merge(ListNode[] a, int lo, int hi){
        if(lo>=hi)return a[lo];
        int mid=lo+(hi-lo)/2;
        ListNode m1= merge(a, lo, mid);
        ListNode m2= merge(a, mid+1, hi);
        return sort(m1, m2);

    }
    ListNode sort(ListNode h1, ListNode h2){
        ListNode x= new ListNode(0);
        ListNode head=x;
        while(h1!=null || h2!=null){
            if(h1==null && h2!=null){
                x.next=h2;
                h2=h2.next;
            }else if (h1!=null && h2==null){
                x.next=h1;
                h1=h1.next;
            }else if (h1.val<h2.val){
                x.next=h1;
                h1=h1.next;
            }else{
                x.next=h2;
                h2=h2.next;
            }
            x=x.next;
        }
        return head.next;
    }
}
