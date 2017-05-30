package problems.medium;

import problems.utils.ListNode;

/**
 * Created by sherxon on 1/2/17.
 */
// there are two solutions 1) with arraylist 2) without any extra space
public class LinkedListRandomNode {


    ListNode head;
    //List<ListNode> a;
    ListNode x;
    /**
     * Returns a random node's value.
     */
    int count = 0;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head=head;
        this.x=head;
        // ListNode x=head;
        // a= new ArrayList<>();
        // while(x!=null){
        //     a.add(x);
        //     x=x.next;
        // }

    }

    public int getRandom() {
        // int rand=(int) (Math.random()*a.size());
        // return a.get(rand).val;
        ListNode rr=head;
        if(x!=null){
            count++;
            rr=x;
            x=x.next;
        }else{
            int rand=(int)(Math.random()*count);
            for(int i =1; i<=rand; i++)rr=rr.next;
        }
        return rr.val;

    }
}
