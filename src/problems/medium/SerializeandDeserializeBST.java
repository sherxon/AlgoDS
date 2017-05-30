package problems.medium;

import problems.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by sherxon on 1/3/17.
 */
public class SerializeandDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb= new StringBuilder();
        f(root, sb);
        return sb.substring(1);
    }
    void f(TreeNode x, StringBuilder sb){
        sb.append(',');
        if(x==null){
            sb.append('#');
            return;
        }
        sb.append(x.val);
        f(x.left, sb);
        f(x.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s.length()==0)return null;
        String[] a=s.split(",");
        if(a.length<1)return null;
        LinkedList<String> linkedList= new LinkedList<>(Arrays.asList(a));
        TreeNode root=new TreeNode(Integer.parseInt(linkedList.removeFirst()));
        m(linkedList, root);

        return root;
    }

    private  void  m(LinkedList<String> list,  TreeNode x) {
        if(!list.getFirst().equals("#")){
            x.left= new TreeNode(Integer.parseInt(list.removeFirst()));
            m(list,  x.left);
        }else list.removeFirst();

        if(!list.getFirst().equals("#")){
            x.right= new TreeNode(Integer.parseInt(list.removeFirst()));
            m(list, x.right);
        }else list.removeFirst();
    }
}
