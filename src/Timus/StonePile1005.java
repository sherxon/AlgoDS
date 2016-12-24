package Timus;

import java.util.Scanner;

/**
 * Created by sherxon on 11/6/16.
 */
public class StonePile1005 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int []a=new int[n];
        int sum=0;
        for (int i = 0; i<n; i++) {
            a[i]=in.nextInt();
            sum+=a[i];
        }
        String[] strings=getAllPermutations(n);

        int min=Integer.MAX_VALUE;

        for (int i = 0; i < strings.length; i++) {
            int left=0;
            int leftVersa=0;
            char[] chars=strings[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if(chars[j]=='1')left+=a[j];
                if(chars[j]=='0')leftVersa+=a[j];
            }
            if(left==sum-left || leftVersa == sum-leftVersa){
                System.out.println(0);
                return;
            }
            int diff1=Math.abs(Math.abs(sum-left)-left);
            int diff2=Math.abs(Math.abs(sum-leftVersa)-leftVersa);
            if(min>diff1)min=diff1;
            if(min>diff2)min=diff2;
        }
        System.out.println(min);
    }

    private static String[] getAllPermutations(int n) {
        int limit= ((int) Math.pow(2, n))/2;
        String[] strings=new String[limit];
        StringBuilder builder=new StringBuilder();

        for (int i = 1; i <=limit; i++) {
            builder.setLength(0);
            String temp=Integer.toBinaryString(i);
            for (int j = temp.length(); j <n ; j++) {
                builder.append("0");
            }
            builder.append(temp);
            strings[i-1]=builder.toString();
        }

        return strings;
    }

}
