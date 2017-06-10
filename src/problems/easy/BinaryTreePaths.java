package problems.easy;

import java.util.ArrayList;
import java.util.List;
import problems.utils.TreeNode;

/**
 * Created by sherxon on 2016-12-30.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null )return new ArrayList<>();

        List<String> r=new ArrayList<>();
        if(root.left!=null){
            List<String> s=binaryTreePaths(root.left);
            for(String str:s)
                r.add(root.val +"->" +str);
        }
        if(root.right!=null){
            List<String> s=binaryTreePaths(root.right);
            for(String str:s)
                r.add(root.val +"->" +str);
        }
        if(root.left==null && root.right==null)
            r.add(0, root.val + "");

        return r;

    }

    /**
     * This is recursive solution with StringBuilder
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "");
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        go(list, root.left, new StringBuilder(sb));
        go(list, root.right, new StringBuilder(sb));

        return list;
    }

    void go(List<String> list, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append("->").append(root.val);

        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        go(list, root.left, new StringBuilder(sb));
        go(list, root.right, new StringBuilder(sb));

    }
}
