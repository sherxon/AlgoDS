package problems.easy;

/**
 * Created by sherxon on 1/13/17.
 */
public class LargestDifferenceArray {
    public static void main(String[] args) {
        System.out.println(largestDiff(new int[]{14, 2, 11, 20, 0, 30, 6}));
    }

    static int largestDiff(int[] a) {
        if (a.length == 0) return 0;
        int sum = 0;
        int min = a[0];
        int max = a[0];
        int maxi = 0;
        int mini = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= max) {
                maxi = i;
                max = a[i];
            } else if (a[i] < min) {
                mini = i;
                min = a[i];
                if (mini > maxi) {
                    max = a[i];
                    maxi = mini;
                }
            }
            sum = Math.max(max - min, sum);
        }

        return sum;
    }
}
