package problems.easy;

import problems.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 4/23/17.
 */
public class BinaryTreeTIlt {
    int sum=0;
    Map<TreeNode, Integer> tilts= new HashMap<>();
    Map<TreeNode, Integer> sums=new HashMap<>();

    public static void main(String[] args) {
        System.out.println((char) ('0' + 1));
    }

    public int findTilt(TreeNode root) {
        if(root==null)return sum;
        go(root);
        return sum;
    }
    /**
    * Do post-order traversal and keep track of value sums of each node.
    * */
    void go(TreeNode root){
        if(root==null)return;
        go(root.left);
        go(root.right);

        int leftSum=sums.getOrDefault(root.left, 0);
        int rightSum=sums.getOrDefault(root.right, 0);
        sums.put(root, leftSum + rightSum + root.val);
        tilts.put(root, Math.abs(leftSum-rightSum));
        sum+=tilts.get(root);
    }
}
