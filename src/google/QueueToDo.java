package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 6/20/17.
 */
public class QueueToDo {

  public static void main(String[] args) {

    Map<Integer, Integer> map = new HashMap<>();
    System.out.println(map.get(1));
    map.put(2, null);
    System.out.println(map.get(2));
    //System.out.println(answer(17,4));
  }

  static int answer(int start, int length) {
    int res = start;
    int left = start;
    int adder = length;
    boolean first = true;
    while (length > 0) {
      if (first) {
        res ^= xor(left + 1, left + length - 1);
        first = false;
      } else {
        res ^= xor(left, left + length - 1);
      }
      left += adder;
      length--;
    }

    return res;
  }

  static int helper(int a) {
    int res[] = {a, 1, a + 1, 0};
    return res[a % 4];
  }

  static int xor(int a, int b) {
    return helper(b) ^ helper(a - 1);
  }

}
