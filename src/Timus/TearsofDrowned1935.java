package Timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/6/16.
 */
public class TearsofDrowned1935 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int sum=0;
        int max=0;
        for (int i = 0; i < n; i++) {
            int k=in.nextInt();
            sum+=k;
            if(max<k)max=k;
        }
        System.out.println(sum+max);
    }
}
