package InterviewQuestions.Easy;

import InterviewQuestions.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 12/30/16.
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
}
