package problems.easy;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sherxon on 2016-12-24.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> l=new LinkedList<>();
        l.add(null);
        List<Integer> ll=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        Queue<TreeNode> qq=new LinkedList<>();

        if(root!=null)q.add(root);

        while(!q.isEmpty()){
            TreeNode t=q.remove();
            ll.add(t.val);
            if(q.isEmpty()){
                l.addFirst(new ArrayList<>(ll));
                ll.clear();
            }


            if(t.left!=null)qq.add(t.left);
            if(t.right!=null)qq.add(t.right);
            if(q.isEmpty()){
                q.addAll(new LinkedList<>(qq));
                qq.clear();
            }
        }
        return l;
    }
}
