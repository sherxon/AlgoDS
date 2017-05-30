package problems.easy;

import problems.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 2016-12-24.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public void swap(TreeNode x){
        TreeNode temp=x.left;
        x.left=x.right;
        x.right=temp;
    }
    public void invertIterative(TreeNode node){
        
        Queue<TreeNode> q= new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            TreeNode x=q.poll();
            swap(x);
            if(x.left!=null)q.add(x.left);
            if(x.right!=null)q.add(x.right);

        }
    }
}
