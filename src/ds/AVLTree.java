package ds;

/**
 * Created by sherxon on 12/18/16.
 */
// balanced Binary search tree
// insert -> O(lgN), 2lgN max complexity
// search -> O(lgN)
// remove -> O(lgN)
// no duplicate is allowed, for duplicate supported BST look BSTWithDuplicate.java
// most methods are iterative, look BST.java for recursive approach BST

public class AVLTree<K extends Comparable> implements Tree<K> {

    private Node root;


    private Node put(Node x, K k) {
        if (x == null) return new Node(k);
        if (x.value.compareTo(k) > 0) {
            x.left = put(x.left, k);
            x.lSize=1+size2(x.left);
        } else if (x.value.compareTo(k) < 0) {
            x.right = put(x.right, k);
            x.rSize=1+size2(x.right);
        }
        if (x.lSize - x.rSize > 1) {
            if (x.left.lSize >= x.left.rSize)
                x = rotateRight(x);
            else {
                x.left = rotateLeft(x.left);
                x = rotateRight(x);
            }
        } else if (x.lSize - x.rSize < -1) {
            if(x.right.rSize>=x.right.lSize)
                x=rotateLeft(x);
            else{
                x.right=rotateLeft(x.right);
                x=rotateLeft(x);
            }
        }
        return x;
    }

    private Node rotateLeft(Node x) {
        Node newRoot=x.right;
        x.right=newRoot.left;
        newRoot.left=x;

        x.lSize = 1 + size2(x.left);
        x.rSize = 1 + size2(x.right);
        newRoot.lSize = 1 + size2(newRoot.left);
        newRoot.rSize = 1 + size2(newRoot.right);

        return newRoot;
    }


    private Node rotateRight(Node x) {
        Node newRoot = x.left;
        x.left = newRoot.right;
        newRoot.right = x;

        x.lSize = 1 + size2(x.left);
        x.rSize = 1 + size2(x.right);
        newRoot.lSize = 1 + size2(newRoot.left);
        newRoot.rSize = 1 + size2(newRoot.right);
        return newRoot;
    }


    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    private int size2(Node x) {
        return x == null ? -1 : x.lSize + x.rSize;
    }

    @Override
    public void insert(K k) {
        root = put(root, k);
    }

    @Override
    public boolean search(K k) {
        return find(root, k)!=null;
    }

    private Node find(Node x, K k) {
        if(x==null)return null;
        if(x.value.equals(k))return x;
        if(x.value.compareTo(k)>0)
            return find(x.left, k);
        else
            return find(x.right, k);
    }

    @Override
    public void delete(K k) {

    }


    private class Node {
        K value;
        int size, rSize, lSize;
        Node left, right;

        public Node(K k) {
            this.value = k;
        }
    }
}
