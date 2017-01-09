package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class CentipedesMorning1876 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int max1=b*2+40;
        int max2=39*2 + 40 + (a-40)*2 + 1;
        int max=Math.max(max1, max2);
        System.out.println(max);
    }
}
