package Timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/8/16.
 */
public class DontAskWomanaboutHerAge1104 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] a=in.nextLine().toCharArray();
        int max=0;
        long sum=0;
        int k=0;
        for (int i = 0; i < a.length; i++) {

            if(Character.isAlphabetic(a[i]))
                k=a[i]-55;
            else {
                k=a[i]-48;
            }
            if(k>max)max=k;
            sum+=k;
        }
        int i = max+1;
        boolean yes=false;
        for (; i <=36 ; i++) {
            if(i-1>0 && sum%(i-1)==0) {
                yes=true;
                break;
            }
        }
        System.out.println(yes ? i : "No solution.");
    }
}
