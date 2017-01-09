package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class PenaltyTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int sum=0;
        for (int i = 0; i < 10; i++) {
            sum+=in.nextInt();
        }
        sum*=20;
        System.out.println(m-sum >= n ? "No chance." : "Dirty debug :(");
    }
}
