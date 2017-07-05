package google;

import java.math.BigInteger;

/**
 * Created by sherxon on 6/16/17.
 *
 *
 */
public class Re_Id {

  public static void main(String[] args) {
    System.out.println(answer2(0));
    System.out.println(answer2(1));
    System.out.println(answer2(2));
    System.out.println(answer2(10000));
    //System.out.println(answer2(10000));
  }

  public static String answer(int n) {

    boolean[] primes = new boolean[104744];
    primes[0] = true;
    primes[1] = true;
    for (int i = 2; i < primes.length; i++) {
      if (!primes[i]) {
        for (int j = i * i; j >= 0 && j < primes.length; j += i) {
          primes[j] = true;
        }
      }
    }

    StringBuilder builder = new StringBuilder();
    int i;
    for (i = 0; i < primes.length; i++) {
      if (n <= 0) {
        break;
      }
      if (!primes[i]) {
        n--;
      }
    }
    //  System.out.println(i);
    for (; i < primes.length; i++) {
      if (!primes[i]) {
        builder.append(i);
      }

      if (builder.length() >= 5) {
        break;
      }
    }
    //  System.out.println(builder+" builder");
    return builder.substring(0, 5);
  }

  public static String answer2(int n) {
    StringBuilder builder = new StringBuilder();
    BigInteger prime = BigInteger.valueOf(2);
    while (builder.length() - n <= 5) {
      builder.append(prime);
      prime = prime.nextProbablePrime();
    }
    //System.out.println(prime);
    return builder.toString().substring(n, n + 5);
  }

}
