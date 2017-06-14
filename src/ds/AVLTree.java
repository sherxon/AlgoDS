package ds; // sa

/**
 * Created by sherxon on 2016-12-18.
 */
// balanced Binary search tree
// insert -> O(lgN), 2lgN max complexity
// search -> O(lgN)
// remove -> O(lgN)

public class AVLTree<K extends Comparable> implements Tree<K> {
    private Node root;

    private Node put(Node x, K k) {
        if (x == null) return new Node(k);
        if (x.value.compareTo(k) > 0)
            x.left = put(x.left, k);
         else if (x.value.compareTo(k) < 0)
            x.right = put(x.right, k);

        int balance= height(x.left) - height(x.right);
        if ( balance > 1) {
            if (height(x.left.left) >= height(x.left.right))
                x = rotateRight(x);
            else {
                x.left = rotateLeft(x.left);
                x = rotateRight(x);
            }
        } else if (balance < -1) {
            if(height(x.right.right)>=height(x.right.left))
                x=rotateLeft(x);
            else{
                x.right=rotateLeft(x.right);
                x=rotateLeft(x);
            }
        }else{
            x.height=Math.max(height(x.left), height(x.right))+1;
            x.size=size(x.left)+size(x.right)+1;
        }
        return x;
    }

    private Node rotateLeft(Node x) {
        Node newRoot=x.right;
        x.right=newRoot.left;
        newRoot.left=x;
        x.height=Math.max(height(x.left), height(x.right))+1;
        newRoot.height=Math.max(height(newRoot.left), height(newRoot.right))+1;
        return newRoot;
    }


    private Node rotateRight(Node x) {
        Node newRoot = x.left;
        x.left = newRoot.right;
        newRoot.right = x;
        x.height=Math.max(height(x.left), height(x.right))+1;
        newRoot.height=Math.max(height(newRoot.left), height(newRoot.right))+1;
        return newRoot;
    }


    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    private int height(Node x) {
        return x == null ? -1 : x.height;
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
        int height, size;
        Node left, right;

        public Node(K k) {
            this.value = k;
        }
    }
}
