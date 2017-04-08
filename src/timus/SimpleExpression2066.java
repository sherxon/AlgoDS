package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 2016-11-30.
 */
public class SimpleExpression2066 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        if(b==0 || c==0) System.out.println(a-Math.max(b,c));
        else if( b==1) System.out.println(a-b-c);
        else System.out.println(a-b*c);

    }
}
