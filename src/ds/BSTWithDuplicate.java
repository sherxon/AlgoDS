package ds;

/**
 * This is another version of binary search tree with support of duplicates.
 * Idea: store extra variable that counts the number of duplicates in each node.
 */

public class BSTWithDuplicate<K extends Comparable> implements Tree<K> {
    private Node root;

    @Override
    public void insert(K k) {
        if (k == null) throw new NullPointerException();
        root = newNode(k, root);
    }

    private Node newNode(K k, Node root) {
        if (root == null) return new Node(k, null);

        if (k.compareTo(root.value) < 0)
            root.left = newNode(k, root.left);
        else if (k.compareTo(root.value) > 0)
            root.right = newNode(k, root.right);
        else
            root.duplicateCount++;

        return root;
    }

    @Override
    public boolean search(K k) {
        if (k == null) throw new NullPointerException();
        return find(k, root);
    }

    private boolean find(K k, Node root) {
        if (root == null) return false;
        if (k.compareTo(root.value) > 0)
            return find(k, root.right);
        else if (k.compareTo(root.value) < 0)
            return find(k, root.left);
        else
            return true;
    }

    @Override
    public void delete(K k) {
        // this is the same implementation as other BST provided with small change i.e. decrement
        // node counter if it is more than one otherwise remove it.
    }

    public int numberOf(K k) {
        if (k == null) throw new NullPointerException();
        return numberOf(k, root);
    }

    private int numberOf(K k, Node root) {
        if (root == null) return 0;
        if (k.compareTo(root.value) > 0)
            return numberOf(k, root.right);
        else if (k.compareTo(root.value) < 0)
            return numberOf(k, root.left);
        else
            return root.duplicateCount;
    }

    private class Node {
        K value;
        int size = 1;
        int duplicateCount = 1;
        Node left, right, parent;

        public Node(K k, Node parent) {
            this.value = k;
            this.parent = parent;
        }
    }
}
