package problems.medium;

/**
 * Created by sherxon on 1/28/17.
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] a, int t) {
        if (a.length == 0 || t == 0) return 0;
        if (a.length == 1) return t;

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                count += t;
                continue;
            }
            if (a[i - 1] + t - 1 < a[i]) {
                count += t;
            } else {
                int need = a[i] + t - 1 - (a[i - 1] + t - 1);
                count += need;
            }
        }

        return count;
    }
}
