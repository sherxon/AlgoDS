package InterviewQuestions.Medium;

import InterviewQuestions.ListNode;

/**
 * Created by sherxon on 1/8/17.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        return sort(head);
    }
    ListNode sort(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode start2=slow.next;
        slow.next=null;

        ListNode start1 = sort(head);
        ListNode start11=sort(start2);

        return merge(start1, start11);
    }

    ListNode merge(ListNode a, ListNode b){
        ListNode root=new ListNode(0);
        ListNode x=root;
        while(a!=null || b!=null){
            if(a==null){
                x.next=b;
                b=b.next;
            }else if(b==null){
                x.next=a;
                a=a.next;
            }else if (a.val<=b.val){
                x.next=a;
                a=a.next;
            }else{
                x.next=b;
                b=b.next;
            }
            x=x.next;
        }
        return root.next;
    }
}
