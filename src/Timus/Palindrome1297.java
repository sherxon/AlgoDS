package Timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/8/16.
 */
public class Palindrome1297 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] a=in.nextLine().toCharArray();
        int start=0;
        int max=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j < a.length; j++) {
                boolean isPalin=isPalin(a, i, j);
                if(isPalin){
                    if(max<j-i){
                        max=j-i;
                        start=i;
                    }
                }
            }
        }
        for (int i = start; i <=start+max; i++) {
            System.out.print(a[i]);
        }
    }

    private static boolean isPalin(char[] a, int i, int j) {

        int mid= i + (j-i)/2;
        for (int k = i; k <=mid; k++) {
            if(a[k]!=a[j--])return false;
        }
        return true;
    }

    public static void n2palindrome(String s){
        char[] a=s.toCharArray();
        int start=0;
        int max=0;
        for (int mid = 0; mid <a.length; mid++) {
            int left=mid;
            int right=mid; //for odd case : 12321
            while (left>=0 && right<a.length){
                if(a[left]!=a[right])break;
                if(right-left > max){
                    max=right=left;
                    start=left;
                }
                right--;
                left++;
            }

             left=mid;
             right=mid+1; // for even case : 123321
            while (left>=0 && right<a.length){
                if(a[left]!=a[right])break;
                if(right-left > max){
                    max=right=left;
                    start=left;
                }
                right--;
                left++;
            }
        }
        System.out.println(s.substring(start, start+max));
    }
}
