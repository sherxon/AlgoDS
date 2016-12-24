package Timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sherxon on 12/3/16.
 */
public class FinalStandings1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        Pair[] pairs= new Pair[n];
        String[] s=null;
        for (int i = 0; i < n; i++) {
            s=in.readLine().split(" ");
            int id=Integer.parseInt(s[0]);
            int sums=Integer.parseInt(s[1]);
            pairs[i]= new Pair(id, sums);
        }
        sort(pairs);

    }

    private static void sort(Pair[] pairs) {
        Pair[] temp=new Pair[pairs.length];
        sort(pairs, 0, pairs.length-1, temp);
        for (int i = pairs.length-1; i >=0; i--) {
            System.out.println(pairs[i].id + " " + pairs[i].sums);
        }
    }

    private static void sort(Pair[] a, int lo, int hi, Pair[] temp) {
        if(lo >= hi)return;
        int mid=lo+ (hi - lo)/2; //4
        sort(a, lo, mid, temp); // 0->4
        sort(a, mid + 1, hi, temp); // 5->9
        merge(a, lo, mid, hi, temp);

    }

    private static void merge(Pair[] a, int lo, int mid, int hi, Pair[] b) {
        int i=lo;
        int j=mid+1;
        for (int k = lo; k <=hi ; k++) {
            b[k]=a[k];
        }
        for (int k = lo; k <=hi ; k++) {
            if(i > mid)     a[k]=b[j++];
            else if(j > hi)a[k]=b[i++];
            else if(b[i].sums < b[j].sums) a[k]=b[i++];
            else a[k]=b[j++];
        }
    }

    private static class Pair{
        int id;
        int sums;

        public Pair(int id, int sums) {
            this.id = id;
            this.sums = sums;
        }
    }

}
