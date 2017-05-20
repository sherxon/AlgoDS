package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] a) {
        if (a.length == 0) return null;
        if(a.length==1)return a[0];

        return sort(a, 0, a.length - 1);
    }

    ListNode sort(ListNode[] a, int lo, int hi) {
        if (lo >= hi) return a[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode left = sort(a, lo, mid);
        ListNode right = sort(a, mid + 1, hi);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode x= new ListNode(0);
        ListNode xx = x;
        while (left != null || right != null) {
            if (left == null) {
                x.next = right;
                break;
            } else if (right == null) {
                x.next = left;
                break;
            }else{
                if (left.val < right.val) {
                    x.next = left;
                    left = left.next;
                } else {
                    x.next = right;
                    right = right.next;
                }
            }
            x=x.next;
        }
        return xx.next;
    }
}
