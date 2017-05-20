package problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/13/17.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;

        }

        return true;
    }
}
