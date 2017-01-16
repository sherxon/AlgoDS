package interviewquestions.medium;

import interviewquestions.utils.ListNode;

/**
 * Created by sherxon on 1/8/17.
 */
public class ReorderList {
    ListNode r = null;
    boolean done = false;

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
      //  listNode.next.next.next=new ListNode(4);
      //  listNode.next.next.next.next=new ListNode(5);
        //listNode.next.next.next.next.next=new ListNode(6);
        new ReorderList().reorderList(listNode);
        System.out.println(listNode);
    }

    public void reorderList(ListNode head) {
        if(head==null)return;
        r=head;
        reorder(head);
    }
    void reorder(ListNode head){
        if(head==null)return;
        reorder(head.next);
        if(r==head && !done){
            done=true;
            head.next=null;
        }else if(r.next==head && !done){
            done=true;
            head.next=null;
        } else if(!done){
            ListNode temp=r.next;
            r.next=head;
            r.next.next=temp;
            r=temp;
        }
    }
}

