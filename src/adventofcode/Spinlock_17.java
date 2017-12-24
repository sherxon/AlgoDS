package adventofcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates") public class Spinlock_17 {
    public static void main(String[] args) {
        System.out.println(solve2(301));
    }

    private static int solve(int n) {
        if (n <= 0)
            return 0;
        Map<Node, Integer> map = new HashMap<>();
        Node current = new Node(0, null);
        Node root = current;
        map.put(current, 0);
        Node ipNode;
        for (int i = 1; i <= 2017; i++) {
            int ip = (n + map.get(current)) % map.size();
            ipNode = findByIndex(root, ip);
            ipNode.next = new Node(i, ipNode.next);
            map.put(ipNode.next, ip + 1);
            current = ipNode.next;
        }
        return current.next.value;
    }

    private static int solve2(int n) {
        if (n <= 0)
            return 0;
        int k = 0;
        int currentIndex = 0;
        for (int i = 1; i <= 50_000_000; i++) {
            currentIndex = (n + currentIndex) % i + 1;
            if (currentIndex - 1 == 0) {
                k = i;
            }
        }
        return k;
    }

    private static void printNode(Node root) {
        while (root != null) {
            System.out.print(root.value + " ");
            root = root.next;
        }
        System.out.println();
    }

    private static Node findByIndex(Node root, int ip) {
        int i = 0;
        while (i < ip) {
            root = root.next;
            i++;
        }
        return root;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Node node = (Node) o;

            if (value != node.value)
                return false;
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override public int hashCode() {
            return value;
        }
    }
}
