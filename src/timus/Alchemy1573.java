package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 2016-12-10.
 */
public class Alchemy1573 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int b=in.nextInt();
        int r=in.nextInt();
        int y=in.nextInt();
        int k=in.nextInt();
        int sum=1;
        for (int i = 0; i < k; i++) {
                String s=in.next();
            if(s.equals("Red"))sum*=r;
            else if(s.equals("Yellow"))sum*=y;
            else sum*=b;
        }
        System.out.println(sum);
    }
}
