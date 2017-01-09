package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/7/16.
 */
public class LongStatement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int one=0;
        int two=0;
        int three=0;
        for (int i = 0; i < n; i++) {
            int k=in.nextInt();
            if(k==1)one++;
            else if(k==2)two++;
            else three++;
        }
        if(n>5){

            if((one==0 && two==0) || (one==0 && three==0) || (two==0 && three==0)) System.out.println("No");
            else System.out.println("Yes");
        }else{
            int f=1;
            for (int i = 1; i <=n ; i++)
                f*=i;

            int temp=1;
            for (int i = 1; i <= one; i++) {
                temp*=i;
            }
            f/=temp;
            temp=1;
            for (int i = 1; i <= two; i++) {
                temp*=i;
            }
            f/=temp;
            temp=1;
            for (int i = 1; i <= three; i++) {
                temp*=i;
            }
            f/=temp;

            System.out.println(f>5 ? "Yes" : "No");
        }


    }


}
