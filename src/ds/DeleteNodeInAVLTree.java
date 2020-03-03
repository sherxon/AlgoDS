package ds;

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

    public void delete(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        root = deleteHelper(root, elem);
    }

    private AVLNode<E> deleteHelper(AVLNode<E> node, E elem) {
        if (node.elem.compareTo(elem) > 0) node.left = deleteHelper(node.left, elem);
        else if (node.elem.compareTo(elem) < 0) node.right = deleteHelper(node.right, elem);
        else {                                             // found, now let's remove it
            if (node.left == null && node.right == null) {
                node = null;                               // case 1: if the node has no child
            } else if (node.left == null || node.right == null) {
                if (node.left != null) node = node.left;   // case 2: if the node has only one child
                else node = node.right;
            } else {                                       // case 3: if the node has two child
                AVLNode<E> p = findMin(node.left);
                node.elem = p.elem;
                node.left = deleteHelper(node.left, p.elem);
            }
        }

        if (node == null) return null;
        node.height = max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return node;
    }

    private AVLNode<E> findMin(AVLNode<E> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
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
