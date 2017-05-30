package problems.medium;

/**
 * Created by sherxon on 1/14/17.
 */
public class MaxConsecutiveZeros2 {

    int findMaxConsecutiveOnes2(int[] a) {
        int max = findMaxConsecutiveOnes(a);
        if (max < a.length) max += 1;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == 0 && a[i - 1] == 1 && a[i + 1] == 1) {
                a[i] = 1;
                int count = findMaxConsecutiveOnes(a);
                a[i] = 0;
                max = Math.max(count, max);
            }
        }
        return max;
    }

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
        return counter;
    }
}
