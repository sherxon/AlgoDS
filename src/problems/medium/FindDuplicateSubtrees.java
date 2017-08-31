package problems.medium;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sherali Obidov.
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if(root==null) return list;

        Map<String, Integer> map= new HashMap<>();
        postOrder(root, map, list);
        return list;
    }

    String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> list){
        if(root==null)return ".";
        String s= root.val + "," + postOrder(root.left, map, list) + "," + "," + postOrder(root.right, map, list);
        if(map.getOrDefault(s, 0)==1)list.add(root);
        map.put(s, map.getOrDefault(s, 0)+1);
        return s;
    }

}
