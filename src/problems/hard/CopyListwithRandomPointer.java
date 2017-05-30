package problems.hard;

import problems.utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 1/6/17.
 */
public class CopyListwithRandomPointer {
    /**
     * This duplicates each node next to original one. on the second round of iteration it sets random elements
     * on the third round of iteration we remove original ones and duplicates are left. 3 iteration and no extra space
     */

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;

        //duplicate each node
        RandomListNode x = head;
        while (x != null) {
            RandomListNode copy = new RandomListNode(x.label);
            copy.next = x.next;
            x.next = copy;
            x = copy.next;
        }

        //set random to duplicated nodes
        x = head;
        while (x != null) {
            RandomListNode copy = x.next;
            if (x.random != null)
                copy.random = x.random.next;
            x = copy.next;
        }

        //remove original nodes
        RandomListNode fakeHead = new RandomListNode(0);
        RandomListNode Head = fakeHead;
        x = head;
        while (x != null) {
            RandomListNode next = x.next.next;
            RandomListNode copy = x.next;
            fakeHead.next = copy;
            fakeHead = fakeHead.next;
            x.next = next;
            x = next;
        }

        return Head.next;

    }

    /**
     * Two round iteration solution using hashmap to find copy pair of original node.
     */

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode x = head;
        RandomListNode newhead = new RandomListNode(0);
        RandomListNode newheadHelper = newhead;

        while (x != null) {
            newheadHelper.next = new RandomListNode(x.label);
            map.put(x, newheadHelper.next);
            x = x.next;
            newheadHelper = newheadHelper.next;
        }

        newheadHelper = newhead.next;
        x = head;

        while (x != null) {
            if (x.random != null)
                newheadHelper.random = map.get(x.random);

            newheadHelper = newheadHelper.next;
            x = x.next;
        }

        return newhead.next;

    }
}
