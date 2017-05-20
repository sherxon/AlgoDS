package problems.medium;

import problems.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 2/12/17.
 */

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 */
/**
* We get left side view of binary tree and return last element.
* */
public class FindLeftMostElement {

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<Integer> list=new LinkedList<>();
        find(root, list, 0);
        return list.getLast();

    }
    void find(TreeNode x, List<Integer> list, int level){
        if(x==null)return;
        if(list.size()==level)list.add(x.val);
        find(x.left, list, level+1);
        find(x.right, list, level+1);
    }
}
