package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/9/16.
 */
public class AmusementPark1796 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tens=in.nextInt();
        int fifties=in.nextInt();
        int hundreds=in.nextInt();
        int fivehundreds=in.nextInt();
        int thousands=in.nextInt();
        int fivethousands=in.nextInt();
        int price=in.nextInt();
        long all=tens*10+fifties*50+hundreds*100+fivehundreds*500+thousands*1000+fivethousands*5000;
        long max=all/price;
        int min=0;
        if(tens>0)min=10;
        else if(fifties>0)min=50;
        else if(hundreds>0)min=100;
        else if(fivehundreds>0)min=500;
        else if(thousands>0)min=1000;
        else if(fivethousands>0)min=5000;

        long mini=(all-min)/price;
        System.out.println(max - mini);
        for (long i = mini+1; i <=max; i++) {
            System.out.print(i + " ");
        }


    }
}
