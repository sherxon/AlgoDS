package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/4/16.
 */
public class A3801893 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int n=0;
        char c=0;
        if (s.length()==2){
            n=Integer.parseInt(String.valueOf(s.charAt(0)));
            c=s.charAt(1);
        }else{
            n=Integer.parseInt(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1)));
            c=s.charAt(2);
        }
        if(n<3){
         if(c=='B' || c=='C') System.out.println("aisle");
         else System.out.println("window");
        }else if(n <21){
            if(c=='B' || c=='C' || c=='D' || c=='E') System.out.println("aisle");
            else System.out.println("window");
        }else{
            if(c=='C' || c=='D' || c=='G' || c=='H') System.out.println("aisle");
            else if(c=='A' || c=='K') System.out.println("window");
            else System.out.println("neither");
        }
    }
}
