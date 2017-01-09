package timus;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sherxon on 12/4/16.
 */
public class DivorceoftheSevenDwarfs1243 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        BigInteger integer=new BigInteger(in.next());
        System.out.println(integer.remainder(new BigInteger(String.valueOf(7))));
    }
}
