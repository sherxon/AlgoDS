package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class WeddingDinner2100 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int count=0;
        count+=n;
        count+=2;
        for (int i = 0; i < n; i++) {
            String s=in.nextLine();
            int inde=s.indexOf("+one");
            if(inde>0){
                count++;
            }
        }
        if(count==13)count+=1;
        System.out.println(count*100);

    }
}
