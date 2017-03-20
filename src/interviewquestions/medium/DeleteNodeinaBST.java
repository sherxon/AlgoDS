package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 1/12/17.
 */
public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.left == null && root.right == null && root.val == key) return null;
        root = remove(root, root, key);
        return root;
    }

    TreeNode remove(TreeNode x, TreeNode parent, int key) {
        if (x == null) return null; // base case
        if (x.val > key)
            remove(x.left, x, key); // search from left
        else if (x.val < key)
            remove(x.right, x, key); // search from right
        else { // found, now remove it
            if (x.left == null && x.right == null) { // case 1: when the node has no children
                if (parent.left == x) parent.left = null;
                else parent.right = null;
            } else if (x.left != null && x.right != null) { // when the node has two children
                TreeNode successor = x.right;
                parent = x;
                while (successor.left != null) {
                    parent = successor;
                    successor = successor.left;
                }
                int temp = x.val;
                x.val = successor.val;
                successor.val = temp;
                remove(successor, parent, key);
            } else {                                        // when the node has only one child
                if (parent == x) {
                    x = parent.left == null ? parent.right : parent.left;
                } else if (x.left == null) {
                    if (parent.left == x) parent.left = x.right;
                    else parent.right = x.right;
                } else {
                    if (parent.left == x) parent.left = x.left;
                    else parent.right = x.left;
                }
            }
        }
        return x;
    }

}
