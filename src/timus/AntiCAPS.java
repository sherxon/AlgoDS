package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/8/16.
 */
public class AntiCAPS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        char[] a=null;
        boolean b=true;
        while (in.hasNextLine()){
            a=in.nextLine().toCharArray();

            for (int i = 0; i < a.length; i++) {

                if(b && Character.isAlphabetic(a[i])) {
                    builder.append(a[i]);
                    b=false;
                }
                 else
                     builder.append(Character.toLowerCase(a[i]));

                 if( a[i] == '.' || a[i] == '!' || a[i] == '?'){
                     b =true;
                 }
            }

            System.out.println(builder);
            builder.setLength(0);
        }
    }
}
