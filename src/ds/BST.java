package ds;

/**
 * Created by sherxon on 12/16/16.
 */
// Binary Search Tree, two nodes (left, right) one parent.
// insert -> O(h) can be O(n) if input is sorted
// search -> O(h) can be O(n) if input is sorted
// remove -> O(h) can be O(n) if input is sorted
// no duplicate is allowed, for duplicate supported BST look BSTWithDuplicate.java
// most methods are recursive, look BSTIterative.java for iterative approach BST

public class BST<K extends Comparable> {
    private Node root;

    public void insert(K k) {
        root = putRecursive(root, k, null);
    }

    public boolean search(K k) {
        return findRecursive(k, root);
    }
    public void delete(K k){

    }
    public K findMax(){
       return findMaxRecursive(root);
    }
    public K findMin(){
        return findMinRecursive(root);
    }

    private K findMaxRecursive(Node x) {
        if(x.right==null)return x.value;
        else return findMaxRecursive(x.right);
    }
    private K findMinRecursive(Node x) {
        if(x.left==null)return x.value;
        else return findMinRecursive(x.left);
    }

    private boolean findRecursive(K k, Node x) {
        if (x == null) return false;
        if (x.value.equals(k))
            return true;
        else if (x.value.compareTo(k) > 0)
            return findRecursive(k, x.left);
        else
            return findRecursive(k, x.right);
    }

    private Node putRecursive(Node x, K k, Node parent) {
        if (x == null) return new Node(k, parent);
        if (x.value.compareTo(k) > 0)
            x.left = putRecursive(x.left, k, x);
        else if (x.value.compareTo(k) < 0)
            x.right = putRecursive(x.right, k, x);
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
        Node left;
        Node right;
        Node parent;


        public Node(K k, Node parent) {
            this.value = k;
            this.parent = parent;
        }
    }
}
