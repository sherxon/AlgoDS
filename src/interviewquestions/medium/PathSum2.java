package interviewquestions.medium;

import interviewquestions.TreeNode;

import java.util.*;

/**
 * Created by sherxon on 12/25/16.
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> l= new ArrayList<>();
        f(root, sum, l, new ArrayList<>());
        String m="";

        return l;
    }
    void f(TreeNode x, int sum, List<List<Integer>> l, List<Integer> ll){
        if(x==null)return;
        ll.add(x.val);
        f(x.left, sum-x.val, l,new ArrayList<>(ll));
        f(x.right, sum-x.val, l, new ArrayList<>(ll));
        if(x.left==null && x.right==null && sum-x.val==0)l.add(ll);
    }
}
