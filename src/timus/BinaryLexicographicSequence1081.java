package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 2016-12-11.
 */
public class BinaryLexicographicSequence1081 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        if(Math.pow(2, n) < k){
            System.out.println(-1);
        }else{
            long[] f= new long[n*2+1];
            int cost= findFibNumber(f, k);
            findKthNumber(f, k-1, cost, n);
        }

    }

    private static void findKthNumber(long[] f, int k, int cost, int n) {
        long sumFibs=0;
        long res=0;
        while (sumFibs<k){
            if(sumFibs+f[cost] <= k) {
                sumFibs+=f[cost];
                res+=Math.pow(2, cost-1);
            }
            cost--;
        }
        StringBuilder s=new StringBuilder(Long.toBinaryString(res));
        if(s.length() > n)
            System.out.println(-1);
        else {
            int l=s.length();
            for (int i = l; i <n; i++) {
                s.insert(0, "0");
            }
            System.out.println(s);
        }
    }

    private static int findFibNumber(long[] f, int k) {

        f[0]=1;
        f[1]=1;
        f[2]=2;
        int cost=2;
        for (int i = 3; i<k ; i++) {
            if(f[i-1]+f[i-2]>k)break;
            f[i]=f[i-1]+f[i-2];
            cost++;
        }
        return cost;
    }

    private static String calcBinary(long i, int n) {
        StringBuilder builder= new StringBuilder();
        builder.append(Long.toBinaryString(i));
        if(builder.indexOf("11")>=0) return null;
        while (builder.length()<n)builder.insert(0, "0");
        return builder.toString();
    }
}

