package codeforces;

import java.util.Scanner;

/**
 * Created by sherxon on 12/25/16.
 */
public class BachgoldProblem {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        if(n%2==0){
            System.out.println(n/2);
            for (int i = 0; i <n/2 ; i++) {
                System.out.print(2 + " ");
            }
        }else{
            System.out.println((n-3)/2+1);
            for (int i = 0; i <(n-3)/2 ; i++) {
                System.out.print(2+" ");
            }
            System.out.print(3);
        }
    }
}
