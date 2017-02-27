package interviewquestions.medium;

/**
 * Created by sherxon on 2/26/17.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] a, int k) {
        if (a.length == 0) return false;
        if (k == 0) {
            for (int i = 1; i < a.length; i++) {
                a[i] += a[i - 1];
                if (a[i] == 0) return true;
            }
        } else {
            for (int i = 1; i < a.length; i++) {
                a[i] += a[i - 1];
                if (a[i] % k == 0) return true;
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 2; j < a.length; j++) {
                    if ((a[j] - a[i]) % k == 0) return true;
                }
            }
        }

        return false;

    }
}
