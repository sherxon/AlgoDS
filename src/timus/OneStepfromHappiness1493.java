package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class OneStepfromHappiness1493 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int a=Integer.parseInt(s.substring(0, 3));
        int b=Integer.parseInt(s.substring(3));
        boolean res;
        res = Math.abs(getSum(a) - getSum(b + 1)) == 0 || Math.abs(getSum(a) - getSum(b - 1)) == 0;
        System.out.println(res ? "Yes" : "No");

    }

    private static int getSum(int a) {
        int sum=0;
        while (a>0){
            sum+=a%10;
            a/=10;
        }
        return sum;
    }
}
