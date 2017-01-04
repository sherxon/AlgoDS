package InterviewQuestions.Easy;

import InterviewQuestions.ListNode;

/**
 * Created by sherxon on 1/4/17.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode h) {
        ListNode n=null;
        ListNode nn=null;
        while(h!=null){
            nn=h.next;
            h.next=n;
            n=h;
            h=nn;
        }

        return n;
    }
}
