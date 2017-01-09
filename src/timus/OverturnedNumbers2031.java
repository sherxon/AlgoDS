package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/6/16.
 */
public class OverturnedNumbers2031 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        if(n==1) System.out.println("11");
        else if(n==2) System.out.println("11 01");
        else if(n==3) System.out.println("16 06 68");
        else if(n==4) System.out.println("16 06 68 88");
        else System.out.println("Glupenky Pierre");
    }
}
