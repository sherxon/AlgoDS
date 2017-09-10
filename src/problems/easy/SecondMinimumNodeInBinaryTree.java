package problems.easy;

import problems.utils.TreeNode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class SecondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null || root.left==null)return -1;
        Queue<TreeNode> q= new LinkedList<>();
        Set<Integer> set= new HashSet<>();
        q.add(root);

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        while(!q.isEmpty()){
            TreeNode x=q.remove();
            if(set.add(x.val)){
                pq.add(x.val);
            }

            if(x.left!=null)
                q.add(x.left);

            if(x.right!=null)
                q.add(x.right);
        }
        if(set.size()<2)return -1;
        pq.remove();
        return pq.remove();
    }

}
