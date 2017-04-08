package codeforces;

import java.util.Scanner;

/**
 * Created by sherxon on 2016-12-25.
 */
public class ParallelogramisBack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1=in.nextInt();
        int y1=in.nextInt();
        int x2=in.nextInt();
        int y2=in.nextInt();
        int x3=in.nextInt();
        int y3=in.nextInt();
        if(x1+x2==y1+y2){ // x3

        }else if (x2+x3==y2+y3){ //x1
            System.out.println((x2+x3)-x1 + " " +( (x2+x3)-y1));
            System.out.println((x2+x3)-x1 + " " +( (x2+x3)-y1));

        }else{ // x2

        }


    }
}
