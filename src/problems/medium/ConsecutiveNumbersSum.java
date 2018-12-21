package problems.medium;

import java.util.PriorityQueue;

/**
 * Why Did you create this class? what does it do?
 */
public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int n) {

        if (n == 1)
            return 1;
        int count = 1 + n % 2;
        int limit = (int) (-1 + Math.sqrt(1 + 4L * 2L * n)) / 2;
        for (int i = 3; i <= limit; i++) {
            int sum = i * (i + 1) / 2;
            if ((n - sum) % i == 0)
                count++;
        }
        return count;
    }
}
