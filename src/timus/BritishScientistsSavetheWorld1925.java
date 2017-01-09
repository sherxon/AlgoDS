package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class BritishScientistsSavetheWorld1925 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int sum1=k;
        int sum2=0;
        for (int i = 0; i <n; i++) {
            sum1+=in.nextInt();
            sum2+=in.nextInt();
        }
        sum1-=2*(n+1);
        int res=sum1 - sum2;
        System.out.println( res >= 0 ? res : "Big Bang!");
    }
}
