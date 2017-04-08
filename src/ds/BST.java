package ds;

/**
 * Created by sherxon on 2016-12-16.
 */
// Binary Search Tree, two nodes (left, right) one parent.
// insert -> O(h) can be O(n) if input is sorted
// search -> O(h) can be O(n) if input is sorted
// remove -> O(h) can be O(n) if input is sorted
// no duplicate is allowed, for duplicate supported BST look BSTWithDuplicate.java
// most methods are recursive, look BSTIterative.java for iterative approach BST
public class BST<K extends Comparable> implements Tree<K> {
    private Node root;


    @Override
    public void insert(K k) {
        root = put(root, k, null);
    }

    @Override
    public boolean search(K k) {
        return findNode(k, root) != null;
    }

    @Override
    public void delete(K k) {
        Node x = findNode(k, root);
        deleteNode(x);
    }

    private void deleteNode(Node x) {
        if (x == null) return;
        Node p = x.parent;
        if (x.left == null && x.right == null) { // case 1 => when x has no children
            x.parent = null;
            if (p.left == x) p.left = null;
            else p.right = null;
        } else if (x.left == null || x.right == null) {// case 2 => when x has one child
            x.parent = null;
            if (x.left == null) { // x has one right child
                if (p.left == x) // x is left child
                    p.left = x.right;
                else          // x is right child
                    p.right = x.right;
                x.right.parent = p;
            } else { // x has one left child
                if (p.left == x)
                    p.left = x.left;
                else
                    p.right = x.left;
                x.left.parent = p;
            }
        } else { // case 3 =>  x has two children
            Node successor = findMin(x.right); // smallest node on right subtree
            K temp = x.value; // swap
            x.value = successor.value;
            successor.value = temp;
            deleteNode(successor);
        }
    }


    public K findMax() {
        Node max = findMax(root);
        return max == null ? null : max.value;
    }

    public K findMin() {
        Node min = findMin(root);
        return min == null ? null : min.value;
    }

    private Node findMax(Node x) {
        if (x == null) return null;
        if (x.right == null) return x;
        else return findMax(x.right);
    }

    private Node findMin(Node x) {
        if (x == null) return null;
        if (x.left == null) return x;
        else return findMin(x.left);
    }

    private Node findNode(K k, Node x) {
        if (x == null) return null;
        if (x.value.equals(k))
            return x;
        else if (x.value.compareTo(k) > 0)
            return findNode(k, x.left);
        else
            return findNode(k, x.right);
    }

    private Node put(Node x, K k, Node parent) {
        if (x == null) return new Node(k, parent);
        if (x.value.compareTo(k) > 0)
            x.left = put(x.left, k, x);
        else if (x.value.compareTo(k) < 0)
            x.right = put(x.right, k, x);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    //rank of tree
    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    // BST node
    private class Node {
        K value;
        int size = 1;
        Node left, right, parent;

        public Node(K k, Node parent) {
            this.value = k;
            this.parent = parent;
        }
    }
}
