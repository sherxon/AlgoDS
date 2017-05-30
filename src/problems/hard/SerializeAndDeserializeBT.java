package problems.hard;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by sherxon on 4/13/17.
 */
public class SerializeAndDeserializeBT {

    // Encodes a tree to a single string.
    /**
    * We do level order traversal including null nodes
    * */
    public String serialize(TreeNode root) {
        if(root==null)return "";
        List<Integer> list= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=1;
        list.add(root.val);
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            level--;
            if(node!=null){
                q.add(node.left);
                q.add(node.right);
            }
            if(level==0 && !q.isEmpty()){
                level+=q.size();
                for(TreeNode x: q){
                    list.add(x== null ? null : x.val);
                }
            }
        }
        return list.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    /**
    * First we make TreeNode array and set set created TreeNode or null values to T array.
    * then we set left and right children of non-null values of T array.
    * */
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        System.out.println(data);
        String[] a=data.split(",");
        TreeNode[] t=new TreeNode[a.length];
        for(int i=0; i<a.length; i++){
            t[i]=getNode(a[i]);
        }
        int j=1;
        for(int i=0; i<a.length &&  j<a.length-2; i++){
            if(t[i]!=null){
                t[i].left=t[j++];
                t[i].right=t[j++];
            }
        }

        return t[0];
    }
    TreeNode getNode(String s){
        if(s.equals("null"))return null;
        return new TreeNode(Integer.parseInt(s));
    }
}
