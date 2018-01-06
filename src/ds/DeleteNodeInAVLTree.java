package ds;

@SuppressWarnings("Duplicates")
public class DeleteNodeInAVLTree<E extends Comparable<E>> {
    private AVLNode<E> root;

    private int height(AVLNode<E> node) {
        return node == null ? -1 : node.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int getBalance(AVLNode<E> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public void delete(E elem) {
        if (elem == null || root == null) throw new IllegalArgumentException();
        root = deleteHelper(root, elem);
    }

    private AVLNode<E> deleteHelper(AVLNode<E> node, E elem) {
        // usual delete node from tree
        if (node.elem.compareTo(elem) > 0) node.left = deleteHelper(node.left, elem);
        if (node.elem.compareTo(elem) < 0) node.right = deleteHelper(node.right, elem);
        else {
            if (node.left == null && node.right == null) {        // case 1: the node has no child
                node = null;
            } else if (node.left == null || node.right == null) { // case 2: the node has a child
                if (node.left != null) node = node.left;
                else node = node.right;
            } else {                                              // case 3: the node has two child
                AVLNode<E> p = node.left;
                if (p.right != null) {
                    while (p.right.right != null) p = p.right;
                    node.elem = p.right.elem;
                    p.right = null;
                } else {
                    p.right = node.right;
                    node = p;
                }
                node.height = max(height(node.left), height(node.right)) + 1;
                int balance = getBalance(node);

                // if the node is not balanced
                // left-left case
                if (balance > -1 && getBalance(node.left) >= 0) {
                    return rightRotate(node);
                }
                // left-right case
                if (balance > -1 && getBalance(node.left) < 0) {
                    node.left = leftRotate(node);
                    return rightRotate(node);
                }
                // right-right case
                if (balance < -1 && getBalance(node.right) <= 0) {
                    return leftRotate(node);
                }
                // right-left case
                if (balance < -1 && getBalance(node.right) > -1) {
                    node.right = rightRotate(node);
                    return leftRotate(node);
                }
            }
        }
        return node;
    }

    private AVLNode<E> leftRotate(AVLNode<E> x) {
        AVLNode<E> y = x.right;
        AVLNode<E> z = y.left;

        // rotation
        y.left = x;
        x.right = z;

        // update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return x;
    }

    private AVLNode<E> rightRotate(AVLNode<E> y) {
        AVLNode<E> x = y.left;
        AVLNode<E> z = x.right;

        //rotation
        x.right = y;
        y.left = z;

        // update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return x;
    }

    private class AVLNode<E> {
        private int height;
        private E elem;
        private AVLNode<E> left, right;

        public AVLNode(E elem) {
            this.elem = elem;
        }
    }
}
