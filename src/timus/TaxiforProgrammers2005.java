package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/6/16.
 */
public class TaxiforProgrammers2005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [][] a=new int[6][6];
        for (int i = 1; i <=5 ; i++)
            for (int j = 1; j <=5 ; j++)
                a[i][j]=in.nextInt();
        int[][] perm={{1,2,3,4,5},{1,3,2,4,5}, {1,3,4,2,5},{1,4,3,2,5}};
        int max=Integer.MAX_VALUE;
        int [] cit=null;
        for (int i = 0; i < perm.length; i++) {
            int sum=0;
            for (int j = 0; j <perm[i].length-1 ; j++) {
                    sum+=a[perm[i][j]][perm[i][j+1]];
            }
            if(sum<max){
                max=sum;
                cit=perm[i];
            }
        }
        System.out.println(max);
        for (int i = 0; i < cit.length; i++) {
            System.out.print(cit[i] + " ");
        }
    }
}
