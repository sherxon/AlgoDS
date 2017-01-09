package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/3/16.
 */
public class Donaldisapostman2023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= Integer.parseInt(in.nextLine());
        int prev=0;
        int steps=0;
        for (int i = 0; i < n; i++) {
            String s=in.nextLine();
            int b= getBox(s);
            steps+=(Math.abs(prev-b));
            prev=b;
        }
        System.out.println(steps);
    }

    private static int getBox(String s) {
        if(s.startsWith("A") || s.startsWith("P") || s.startsWith("O") || s.startsWith("R"))
            return 0;
        else if(s.startsWith("B") || s.startsWith("M") || s.startsWith("S"))
            return 1;
        else
            return 2;
    }
}
