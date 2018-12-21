package problems.hard;

import java.util.Arrays;

/**
 * Why Did you create this class? what does it do?
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] a) {
        if (a == null || a.length == 0)
            return 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0 || a[i] > a.length) {
                a[i] = 0;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                continue;
            int index = Math.abs(a[i]) - 1;
            if (a[index] == 0)
                a[index] = -1 * Math.abs(a[i]);
            else
                a[index] = -1 * Math.abs(a[index]);
        }
        System.out.println(Arrays.toString(a));
        int i = 0;
        for (; i < a.length; i++) {
            if (a[i] >= 0)
                return i + 1;
        }

        return i + 1;
    }
}
