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
        root = put(root, k, null);
    }

    public boolean search(K k) {
        return findNode(k, root)==null;
    }
    public void delete(K k){
        Node node=findNode(k, root);
        if(node==null)return;

    }


    public K findMax(){
       return findMax(root);
    }
    public K findMin(){
        return findMin(root);
    }

    private K findMax(Node x) {
        if(x.right==null)return x.value;
        else return findMax(x.right);
    }
    private K findMin(Node x) {
        if(x.left==null)return x.value;
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
        Node left;
        Node right;
        Node parent;


        public Node(K k, Node parent) {
            this.value = k;
            this.parent = parent;
        }
    }
}
