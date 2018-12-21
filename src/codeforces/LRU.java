package codeforces;

import java.util.HashMap;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class LRU {

    public static void main(String[] args) {
        LRU lru = new LRU(10);
        lru.put(10, 13);
    }

    int cap = 0;
    Map<Integer, Integer> map;
    Node root, tail;
    Map<Integer, Node> mm = new HashMap<>();

    public LRU(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = mm.get(key);
        if (n.next == null) {
            return map.get(key);
        }
        n.val = n.next.val;
        if (n.next == tail) {
            n.next = null;
            tail = n;
        } else {
            n.next = n.next.next;
        }

        tail.next = new Node(key);
        tail = tail.next;
        mm.put(key, tail);
        return map.get(key);
    }

    public void put(int key, int value) {
        Node n;
        int ex = get(key);

        if (ex == -1) {
            n = new Node(key);
            if (root == null && tail == null)
                root = tail = n;
            else
                tail.next = n;
            tail = n;
        } else {
            n = tail;
        }
        map.put(key, value);
        mm.put(key, n);
        if (map.size() > cap) {
            map.remove(root.val);
            mm.remove(root.val);
            root = root.next;
        }

    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

}
