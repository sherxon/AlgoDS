package problems.medium;

import problems.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 4/15/17.
 */
public class LargestBSTSubtree {
    int max=0;
    Map<TreeNode, Integer> map = new HashMap<>();

    public int largestBSTSubtree(TreeNode root) {
        if(root==null)return 0;
        size(root);
        go(root);
        return max;
    }

    void go(TreeNode x){
        if(x==null)return ;

        if(check(x, Long.MIN_VALUE, Long.MAX_VALUE)){
            max=Math.max(map.get(x), max);
        }
        go(x.left);
        go(x.right);

    }

    boolean check(TreeNode x, long min, long max){
        if(x==null)return true;
        return x.val > min && x.val < max && check(x.left, min, x.val) && check(x.right, x.val, max);
    }

    int size(TreeNode x){
        if(x==null)return 0;
        if(map.containsKey(x))return map.get(x);
        int size=size(x.left) + size(x.right)+1;
        map.put(x, size);
        return size;
    }
}
