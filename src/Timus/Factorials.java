package Timus;

import java.util.Arrays;
import java.util.Scanner;
//164601OZ

/**
 * Created by sherxon on 10/30/16.
 */
public class Factorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int num=Integer.parseInt(s.split(" ")[0]);
        int marks=s.split(" ")[1].length();
        long sum=1;
        for (int i = num; i > 0 ; i-=marks) {
            sum*=i;
        }
        System.out.println(sum);
        Arrays.stream(new int[]{}).sum();

    }
}
