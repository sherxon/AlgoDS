package problems.medium;

import problems.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sherali Obidov.
 */
public class EqualTreePartition {
    Map<TreeNode, Integer> map= new HashMap<>();
    int total=0;
    public boolean checkEqualTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return false;
        total=sum(root);
        return go(root);
    }

    boolean go(TreeNode root){
        if(root==null)return false;
        if(total==map.get(root)*2)return true;
        return go(root.left) || go(root.right);
    }
    int sum(TreeNode root){
        if(root==null)return 0;
        Integer l=map.get(root.left);
        Integer r=map.get(root.right);
        if(l==null)l=sum(root.left);
        if(r==null)r=sum(root.right);
        map.put(root, l+r+root.val);
        return l+r+root.val;
    }
}
