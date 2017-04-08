package ds;

/**
 * Created by sherxon on 2016-12-18.
 */
// Binary Search Tree, two nodes (left, right) and one parent.
// insert -> O(h) can be O(n) if input is sorted
// search -> O(h) can be O(n) if input is sorted
// remove -> O(h) can be O(n) if input is sorted
// no duplicate is allowed, for duplicate supported BST look BSTWithDuplicate.java
// most methods are iterative, look BST.java for recursive approach BST
public class BSTIterative<K extends Comparable> implements Tree<K> {

    private Node root;

    @Override
    public void insert(K k) {
        if(root==null){
            root= new Node(k, null);
            return;
        }
        Node x = root;
        Node p = root;
        while (x != null) {
            p = x;
            if (x.value.equals(k)) return;
            if (x.value.compareTo(k) > 0)
                x = x.left;
            else
                x = x.right;
        }
        Node newNode = new Node(k, p);
        if (p.value.compareTo(k) > 0)
            p.left = newNode;
        else
            p.right = newNode;
    }


    @Override
    public boolean search(K k) {
        Node x = findNode(root, k);
        return x != null;
    }

    private Node findNode(Node x, K k) {
        while (x != null) {
            if (x.value.equals(k)) return x;
            if (x.value.compareTo(k) > 0)
                x = x.left;
            else
                x = x.right;
        }
        return null;
    }


    @Override
    public void delete(K k) {
        Node x = findNode(root, k);
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

    private Node findMin(Node x) {
        if (x == null) return null;
        while (x.left != null) x = x.left;
        return x;
    }

    private Node findMax(Node x) {
        if (x == null) return null;
        while (x.right != null) x = x.right;
        return x;
    }


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
