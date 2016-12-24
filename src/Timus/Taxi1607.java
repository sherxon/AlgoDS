package Timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class Taxi1607 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();
        while (x>a){
            a+=b;
            if(a>x)a=x;
            x-=y;
        }
        System.out.println(Math.max(x, a));
    }
}
