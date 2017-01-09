package timus;

import java.util.Arrays;

/**
 * Created by sherxon on 12/9/16.
 */
public class SegmentTree {
    public static void main(String[] args) {
        int[] a=new int[]{-1, 2, 4, 0};
        int treeSize=a.length*2-1;// if power of two, just multiply by two and substract one
        // else find nextpower of two and multiple by 2 and sabstruct one;
        int[] tree= new int[treeSize];
        for (int i = 0; i < treeSize; i++) {
            tree[i]=Integer.MAX_VALUE; // to build min segment tree
        }
        int low=0;
        int high=a.length-1;
        int pos=0;
        buildTree(a, tree, low, high, pos);
        System.out.println(Arrays.toString(tree));
    }

    private static void buildTree(int[] a, int[] tree, int low, int high, int pos) {
        if(low==high){
            tree[pos]=a[low];
            return;
        }
        int mid=(low+high)/2;
        buildTree(a, tree, low, mid, 2*pos+1);
        buildTree(a, tree, mid+1, high, 2*pos+2);
        tree[pos]=Math.min(tree[2*pos+1], tree[2*pos+2]);
    }
}
