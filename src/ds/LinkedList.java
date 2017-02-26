package ds;

import java.util.NoSuchElementException;

/**
 * Created by sherxon on 2/24/17.
 */
class LinkedList<E> {

    int size;
    private Node head; // the first element
    private Node tail; // the last element

    public void add(E element) {
        // tail and head are the same node when list has only one item
        if (head == null) {
            head = tail = new Node(element);
        } else {
            //assign new node to next of tail and make tail the last element
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    public E get(int index) {
        if (index >= size && index < 0) // check boundaries
            throw new NoSuchElementException();

        // find element at given index
        Node node = head;
        for (int i = 0; i < index; i++)
            node = node.next;

        return node.elem;
    }

    public boolean delete(E element) {
        Node temp = new Node(null, head); // dummy element to avoid if checks
        Node dummy = temp;
        while (temp.next != null) {
            if (temp.next.elem.equals(element)) {
                // if found node is last node of the list, need to change tail
                if (temp.next == tail) tail = temp;
                temp.next = temp.next.next;
                // if found node is first node if the list, need to change head
                head = dummy.next;
                size--;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // wrapper class for list elements
    private class Node {
        E elem;
        Node next;

        public Node(E elem) {
            this.elem = elem;
        }

        public Node(E el, Node node) {
            this.elem = el;
            this.next = node;
        }
    }
}
