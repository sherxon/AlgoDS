package problems.medium;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by sherxon on 1/9/17.
 */
public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        TreeLinkNode head=new TreeLinkNode(1);
        head.left=new TreeLinkNode(2);
        head.right=new TreeLinkNode(3);
        new PopulatingNextRightPointersinEachNode().connect(head);
        System.out.println(head);
    }
    public void connect(TreeLinkNode root) {
        if(root==null)return;
        LinkedList<TreeLinkNode> q=new LinkedList<>();
        LinkedList<TreeLinkNode> level=new LinkedList<>();
        q.add(root);
        level.add(root);
        while(!q.isEmpty()){
            TreeLinkNode x=q.removeFirst();
            if(x.left!=null)
                q.add(x.left);
            if(x.right!=null)
                q.add(x.right);

            level.removeFirst();
            if(level.isEmpty() && !q.isEmpty()){

                ListIterator<TreeLinkNode> iterator=q.listIterator(q.size());
                TreeLinkNode right=null;
                while (iterator.hasPrevious()){
                    TreeLinkNode current=iterator.previous();
                    current.next=right;
                    right=current;
                    level.addFirst(current);
                }
            }
        }
    }
    //second solution
    public void connect2(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }

}
 class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
