package problems.medium;

import problems.utils.TreeNode;

/**
 * Created by sherxon on 2016-12-29.
 */
public class CountCompleteBinarytree {
    public int countNodes(TreeNode x) {
        if(x==null)return 0;
        int l=leftsize(x.left);
        int r=rightsize(x.right);
        if(l==r) return (1<<r) -1;
        else return countNodes(x.left)+countNodes(x.right)+1;
    }

    int leftsize(TreeNode x){
        int count=1;
        while(x!=null){
            x=x.left;
            count++;
        }
        return count;
    }
    int rightsize(TreeNode x){
        int count=1;
        while(x!=null){
            x=x.right;
            count++;
        }
        return count;
    }

}
