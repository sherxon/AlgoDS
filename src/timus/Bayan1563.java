package timus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sherxon on 12/5/16.
 */
public class Bayan1563 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        Set<String> set= new HashSet<>();
        int count=0;
        for (int i = 0; i < n; i++) {
            String s=in.nextLine();
            if(set.contains(s))count++;
            else set.add(s);
        }
        System.out.println(count);
    }
}
