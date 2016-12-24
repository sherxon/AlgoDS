package Timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/1/16.
 */
public class NonYekaterinburgSubway1272 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        UnionFind union=new UnionFind(n+1);
        for (int i = 0; i < m; i++) {
            int j=in.nextInt();
            int l=in.nextInt();
            union.union(j, l);
        }
        System.out.println(union.size()-2);

    }
    private static class UnionFind{
        int [] a;
        int size;

        public UnionFind(int size) {
            a= new int[size];
            for (int i = 0; i < size; i++)
                a[i]=i;
            this.size=size;
        }
        
        public void union(int i, int j){
            int f=find(i);
            int g=find(j);
            a[f]=g;
            if(f!=g)
            size--;
        }
        public int size(){
            return size;
        }

        private int find(int i) {
            if(a[i]==i)return i;
            return find(a[i]);
        }


    }
}
