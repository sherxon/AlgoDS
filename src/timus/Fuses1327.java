package timus;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sherxon on 12/4/16.
 */
public class Fuses1327 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        System.out.println(IntStream.range(a, b+1).filter(s->s%2!=0).count());
    }
}
