package ds;

/**
 * Created by sherxon on 3/20/17.
 */
public class RedBlackTree<K extends Comparable, V> {
    RBNode root;

    public void put(K key, V value) {
        if (root == null) {
            root = new RBNode(key, value, false);
        } else {
            putRecursive(root, key, value);
        }
    }

    private RBNode putRecursive(RBNode x, K key, V value) {
        if (x == null) return new RBNode(key, value);
        if (isBlack(x) && isRed(x.left) && isRed(x.right)) {
            // flip color
            x.isRed = true;
            x.left.isRed = false;
            x.left.isRed = false;
        }
        if (x.key.compareTo(key) > 0)
            x.left = putRecursive(root.left, key, value);
        else if (x.key.compareTo(key) < 0)
            x.right = putRecursive(root.right, key, value);
        else x.value = value;
        return x;
    }

    private boolean isRed(RBNode x) {
        return x != null && x.isRed;
    }

    private boolean isBlack(RBNode x) {
        return x != null && !x.isRed;
    }

    public V get(K key) {
        if (key == null || root == null) return null;
        return getRecursive(root, key);
    }

    private V getRecursive(RBNode root, K key) {
        if (root == null) return null;
        if (root.key.compareTo(key) > 0)
            return getRecursive(root.left, key);
        else if (root.key.compareTo(key) < 0)
            return getRecursive(root.right, key);
        else return root.value;
    }


    private class RBNode {
        K key;
        V value;
        RBNode left, right, parent;
        boolean isRed;

        public RBNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public RBNode(K key, V value, boolean isRed) {
            this.key = key;
            this.value = value;
            this.isRed = isRed;
        }

        public RBNode(K key, V value, RBNode parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }
}
