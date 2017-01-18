package interviewquestions.easy;

import interviewquestions.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by sherxon on 12/24/16.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l=new LinkedList<>();
        if (root == null) return l;
        List<Integer> helper = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        Queue<TreeNode> qq=new LinkedList<>();

        level.add(root);

        while (!level.isEmpty()) {
            TreeNode t = level.remove();
            helper.add(t.val);
            if (level.isEmpty()) {
                l.add(new ArrayList<>(helper));
                helper.clear();
            }

            if(t.left!=null)qq.add(t.left);
            if(t.right!=null)qq.add(t.right);
            if (level.isEmpty()) {
                level.addAll(new LinkedList<>(qq));
                qq.clear();
            }
        }
        return l;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> l = new LinkedList<>();
        if (root == null) return l;

        Queue<TreeNode> level = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();

        qq.add(root);
        level.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        l.add(temp);
        while (!qq.isEmpty()) {
            TreeNode t = qq.remove();
            level.remove();

            if (t.left != null) qq.add(t.left);
            if (t.right != null) qq.add(t.right);

            if (level.isEmpty() && !qq.isEmpty()) {
                List<Integer> lev = qq.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
                l.add(lev);
                level.addAll(new LinkedList<>(qq));
            }
        }
        return l;
    }

    void levelOrder2(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode x=q.poll();
            System.out.println(x.val);
            if(x.left!=null)
                q.add(x.left);
            if(x.right!=null)
                q.add(x.right);
        }
    }
}
