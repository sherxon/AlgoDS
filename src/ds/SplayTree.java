package ds;

/**
 * Created by sherxon on 6/30/17.
 */

import problems.utils.TreeNode;

/**
 * This is implementation os splay tree. Running time is amortized O(logN) for lookup, insertion,
 * deletion. Splay trees splay the tree after each insertion and lookup operations so that accessed
 * nodes get closer to root. Garbage Collection and Cache are best use cases. No need to store additional
 * pointers with each node. There are three cases to consider when splaying:
 * Zig-Zig=> parent node (p) and X node are both left or right children.
 * Zig-Zag =>p is not root and x is the right child and p is the left child, or vice versa
 * Zig => when there is no grandparent of x. (parent is root )
 */
public class SplayTree {
    TreeNode root;

}
