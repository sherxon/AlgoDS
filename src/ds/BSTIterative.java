package ds;

/**
 * Created by sherxon on 12/18/16.
 */
// Binary Search Tree, two nodes (left, right) and one parent.
// insert -> O(h) can be O(n) if input is sorted
// search -> O(h) can be O(n) if input is sorted
// remove -> O(h) can be O(n) if input is sorted
// no duplicate is allowed, for duplicate supported BST look BSTWithDuplicate.java
// most methods are iterative, look BST.java for recursive approach BST
public class BSTIterative<K extends Comparable>  implements Tree<K> {

    private Node root;

    @Override
    public void insert(K k) {

    }


    @Override
    public boolean search(K k) {
        return false;
    }

    @Override
    public void delete(K k) {

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
