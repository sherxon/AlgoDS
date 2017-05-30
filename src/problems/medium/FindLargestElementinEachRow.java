package problems.medium;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sherxon on 2/11/17.
 */

/**
 *
 * */
public class FindLargestElementinEachRow {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        String a=list.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public List<Integer> findValueMostElement(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(root.val);
        int level=1;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode x = queue.removeFirst();
            level--;
            if (x.left != null) {
                queue.addLast(x.left);
                max=Math.max(max, x.left.val);
            }
            if (x.right != null){
                queue.addLast(x.right);
                max=Math.max(max, x.right.val);
            }
            if (level==0 && !queue.isEmpty()) {
                res.add(max);
                max = Integer.MIN_VALUE;
                level+=queue.size();
            }
        }
        return res;
    }
}
