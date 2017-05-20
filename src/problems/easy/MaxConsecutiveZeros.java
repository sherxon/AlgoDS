package problems.easy;

/**
 * Created by sherxon on 1/14/17.
 */
public class MaxConsecutiveZeros {
    int findMaxConsecutiveOnes(int[] a) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                counter++;
                max = Math.max(counter, max);
            } else
                counter = 0;
        }
        return max;
    }
}
