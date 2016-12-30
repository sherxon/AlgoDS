package InterviewQuestions.Easy;

/**
 * Created by sherxon on 12/29/16.
 */
// this can be solved with revesing half of the array
public class PalindromeLinkedList {
    ListNode yy=null;
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        int size=0;
        ListNode x= head;
        while(x!=null){
            size++;
            x=x.next;
        }
        int start=0;
        if(size%2==0)start=size/2+1;
        else start=size/2+2;

        yy=head;
        for(int i=1; i<start; i++)yy=yy.next;

        return f(head, size/2);
    }
    boolean f(ListNode x, int size){
        if(size==1) return x.val==yy.val;
        boolean b= f(x.next, size-1);
        yy=yy.next;
        return b && x.val==yy.val;
    }
}
