package problems.easy;

import problems.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        go(map, root);
        for(Integer key : map.keySet()){
            int v=k-key;
            if(v!=key){
                if(map.containsKey(v))return true;
            }else{
                if(map.get(v)>1)return true;
            }
        }
        return false;
    }
    void go(Map<Integer, Integer> map, TreeNode root){
        if(root==null)return;
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        go(map, root.left);
        go(map, root.right);
    }
}
