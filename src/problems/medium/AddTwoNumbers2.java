package problems.medium;

import problems.utils.ListNode;

import java.util.Stack;

/**
 * Created by sherxon on 1/1/17.
 */
// this can be solved without using any stack
// find size of both lists O(N) and find nodes in the same length and recursively add
// use bottom up recursive to add numbers
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l=new ListNode(0);
        ListNode l2=new ListNode(7);
        l2.next=new ListNode(3);
        new AddTwoNumbers2().addTwoNumbers(l, l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        Stack<ListNode> s1=new Stack<>();
        while(l1!=null){
            s1.add(l1);
            l1=l1.next;
        }
        Stack<ListNode> s2=new Stack<>();
        while(l2!=null){
            s2.add(l2);
            l2=l2.next;
        }
        int carry=0;
        ListNode x=null;

        while( !s1.isEmpty() || !s2.isEmpty() ){
            int val=0;
            if(s1.isEmpty() && !s2.isEmpty()){
                val=s2.pop().val + carry;
            }else if(s2.isEmpty() && !s1.isEmpty()){
                val=s1.pop().val + carry;
            }else{
                val=s2.pop().val + carry + s1.pop().val;
            }

            carry=val/10;
            if(x==null){
                x=new ListNode(val%10);
            }else{
                ListNode nn=new ListNode(val%10);
                nn.next=x;
                x=nn;
            }
        }
         if(carry>0){
             ListNode nn=new ListNode(carry);
             nn.next=x;
             x=nn;
         }

        return x;
    }
}
