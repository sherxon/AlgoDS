package problems.medium;

import problems.utils.TreeNode;

import java.util.LinkedList;

/**
 * @author Sherali Obidov.
 */
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        LinkedList<TreeNode> q= new LinkedList<>();
        q.add(root);
        int count=1;
        int level=1;
        while(!q.isEmpty()){
            level--;
            TreeNode current=q.removeFirst();
            if(current!=null){
                q.add(current.left);
                q.add(current.right);
            }else{
                q.add(null);
                q.add(null);
            }

            if(level==0){
                while(!q.isEmpty()){
                    if(q.getFirst()==null)q.removeFirst();
                    else if(q.getLast()==null)q.removeLast();
                    else break;
                }
                level+=q.size();
                count=Math.max(count, q.size());
            }

        }
        return count;
    }
}
