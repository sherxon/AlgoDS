package Timus;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by sherxon on 12/3/16.
 */
public class Rope1020 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        double r=in.nextDouble();
        double x = 0, y = 0, px = 0, py = 0, fx = 0, fy = 0;
        double l=0;
        for (int i = 0; i < n; i++) {
            x=in.nextDouble();
            y=in.nextDouble();
            if(i==0){fx=px=x;fy=py=y;}
            else {
               l+=Math.sqrt(Math.pow(px-x, 2) + Math.pow(py-y, 2));
                px=x;
                py=y;
            }
        }
        l+=Math.sqrt(Math.pow(x-fx, 2) + Math.pow(y-fy, 2));
        DecimalFormat f=new DecimalFormat("#.##");
        System.out.println(f.format(l+2*r*Math.PI));
    }
}
