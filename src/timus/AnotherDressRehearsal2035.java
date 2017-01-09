package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/6/16.
 */
public class AnotherDressRehearsal2035 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int x=in.nextInt();
        int y=in.nextInt();
        int c=in.nextInt();
        if(x+y < c) System.out.println("Impossible");
        else{
            int a=Math.min(Math.min(x, y), c);
            int b=c-a;
            if(x<y){
                System.out.println(Math.min(a, b) + " "+ Math.max(a, b));
            }else{
                System.out.println(Math.max(a, b) + " "+ Math.min(a, b));
            }
        }

    }
}
