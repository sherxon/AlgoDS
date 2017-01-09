package timus;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by sherxon on 12/1/16.
 */
public class Elections1263 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] a= new int[n+1];
        for (int i = 1; i <=m; i++) {
            int k=in.nextInt();
            a[k]++;
        }
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (int i = 1; i <a.length ; i++) {
            System.out.println(formatter.format(100.0*a[i]/m) + "%");
        }

    }
}
