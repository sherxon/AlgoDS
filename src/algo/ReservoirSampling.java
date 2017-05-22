package algo;

/**
 * Created by sherxon on 5/21/17.
 */
public class ReservoirSampling {

  /**
   * return k random elements from given stream without using any extra space.
   * assume k is valid
   */
  int[] getRandom(int[] stream, int k) {
    int[] result = new int[k];
    int i;
    for (i = 0; i < k; i++) {
      result[i] = stream[i]; // get first k elements into result
    }
    for (; i < stream.length; i++) {
      int rand = (int) (Math.random() * (i + 1)); // get random element between 0 and i

      if (rand < k) {
        result[rand] = stream[i];
      }

    }
    return result;
  }

}
