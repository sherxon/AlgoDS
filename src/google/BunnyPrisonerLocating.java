package google;

import java.math.BigInteger;

/**
 * Created by sherxon on 6/20/17.
 */
//Refer a friend: https://goo.gl/RkwMCp [ready]

public class BunnyPrisonerLocating {

  public static void main(String[] args) {
    System.out.println(answer(100000, 100000));
    int a = 2000000001;
  }

  public static String answer(int x, int y) {
    BigInteger yy = BigInteger.ONE;
    int yi = 1;
    while (yi < y) {
      yy = yy.add(BigInteger.valueOf(yi));
      yi++;
    }
    yi++;
    int xi = 1;
    while (xi < x) {
      yy = yy.add(BigInteger.valueOf(yi));
      xi++;
      yi++;
    }
    return yy.toString();

  }
}
