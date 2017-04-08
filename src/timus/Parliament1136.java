package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 2016-11-23.
 */
public class Parliament1136 {

    public static void main(String[] args) {
        BTree tree= new BTree();
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] a= new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        for (int i = n-1; i >=0 ; i--) {
            tree.add(a[i]);
        }
        tree.dfsRight(tree.root);
    }

    private static class BTree{
        private BNode root;

        public void add(Integer n){
            BNode node=new BNode(n);
            if(root==null)
                root=node;
            else {
                BNode current=root;
                BNode prev=null;
                while (current!=null){
                    prev=current;
                    if(n > current.elem){
                        current=current.right;
                        if(current==null)
                            prev.right=node;
                    }else {
                        current=current.left;
                        if(current==null)
                            prev.left=node;
                    }
                }
            }
        }

        public void dfsRight(BNode start){

            if(!start.visited){
                start.visited=true;
                if(start.right!=null)
                    dfsRight(start.right);
                if(start.left!=null)
                    dfsRight(start.left);
            }
            System.out.println(start.elem);
        }


        private class BNode{
            private Integer elem;
            private BNode left;
            private BNode right;
            private boolean visited;

            public BNode(Integer elem) {
                this.elem = elem;
            }
        }
    }
}
