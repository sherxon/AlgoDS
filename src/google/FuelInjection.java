package google;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by sherxon on 6/24/17.
 */
public class FuelInjection {

  static Map<BigInteger, Integer> map = new HashMap<>();

  public static void main(String[] args) {

    System.out.println(answer("1"));
    System.out.println(answer("15"));
    System.out.println(answer("14"));
  }

  public static int answer(String s) {
    BigInteger n = new BigInteger(s);
    return go(n);
  }

  static private int go(BigInteger n) {
    if (n.compareTo(BigInteger.ZERO) <= 0) {
      return 0;
    }

    if (n.equals(BigInteger.ONE)) {
      return 0;
    }

    boolean pow = n.and(n.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
    if (pow) {
      return n.bitLength() - 1;
    }

    if (map.containsKey(n)) {
      return map.get(n);
    }

    int div = Integer.MAX_VALUE;
    int minus = Integer.MAX_VALUE;
    int plus = Integer.MAX_VALUE;

    if (n.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
      div = go(n.divide(BigInteger.valueOf(2))) + 1;
    } else {
      minus = go(n.add(BigInteger.ONE)) + 1;
      plus = go(n.subtract(BigInteger.ONE)) + 1;
    }
    int res = Math.min(div, Math.min(plus, minus));
    ;
    map.put(n, res);
    return res;
  }

  public static int bfs(String s) {
    BigInteger n = new BigInteger(s);
    if (n.equals(BigInteger.ONE)) {
      return 0;
    }
    Map<BigInteger, Integer> map = new HashMap<>();
    map.put(n, 0);
    Queue<BigInteger> q = new LinkedList<>();
    q.add(n);
    while (!q.isEmpty()) {
      BigInteger current = q.remove();

      BigInteger child;
      if (current.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
        child = current.divide(BigInteger.valueOf(2));
        q.add(child);
        map.put(child, map.get(current) + 1);
      } else {
        child = current.add(BigInteger.ONE);
        q.add(child);
        map.put(child, map.get(current) + 1);

        child = current.subtract(BigInteger.ONE);
        q.add(child);
        map.put(child, map.get(current) + 1);
      }
      boolean pow = child.and(child.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
      if (pow) {
        return child.bitLength() + map.get(current);
      }
      if (child.equals(BigInteger.ONE)) {
        return map.get(current) + 1;
      }
    }
    return -1;
  }
}
