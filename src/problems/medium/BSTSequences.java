package problems.medium;

import problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sherxon on 5/2/17.
 */
/**
*  Problem:
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print all possible
 * arrays that could have led to this tree
* */

public class BSTSequences {
    /**
    * Solution is simple. Do level order traversal in binary search tree, and for each level nodes get all
     * possible permutations to make new lists
    *
    * */
   static List<List<Integer>> getSequences(TreeNode root){
        List<List<Integer>> lists= new ArrayList<>();
        if(root==null)return lists;
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        lists.add(list);

        Queue<TreeNode> levelNodes= new LinkedList<>();
        levelNodes.add(root);
        int level=1;

        while (!levelNodes.isEmpty()){
            TreeNode node=levelNodes.remove();
            level--;
            if(node.left!=null)levelNodes.add(node.left);
            if(node.right!=null)levelNodes.add(node.right);
            if(level==0 && !levelNodes.isEmpty()){
                List<List<Integer>> perms=new ArrayList<>();
                getPermutations(new ArrayList<>(levelNodes), perms, 0);

                List<List<Integer>> lists2=new ArrayList<>();
                for (List<Integer> integers : lists) {
                    for (List<Integer> perm : perms) {
                        List<Integer> newLevel= new ArrayList<>();
                        newLevel.addAll(integers);
                        newLevel.addAll(perm);
                        lists2.add(newLevel);
                    }
                }
                lists=lists2;
            }
        }
        return lists;
    }

    private static void getPermutations(List<TreeNode> levelNodes, List<List<Integer>> lists, int k) {
        if(k==levelNodes.size()){
            List<Integer> list= new ArrayList<>();
            for (TreeNode levelNode : levelNodes) {
                list.add(levelNode.val);
            }
            lists.add(list);
            return;
        }
        for (int i = k; i <levelNodes.size(); i++) {

            TreeNode temp=levelNodes.get(i);
            levelNodes.set(i, levelNodes.get(k));
            levelNodes.set(k, temp);

            getPermutations(levelNodes, lists, k + 1);

            temp=levelNodes.get(i);
            levelNodes.set(i, levelNodes.get(k));
            levelNodes.set(k, temp);
        }
    }
}
