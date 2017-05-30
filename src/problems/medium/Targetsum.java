package problems.medium;

/**
 * Created by sherxon on 1/21/17.
 */
public class Targetsum {
    static int counter = 0;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{0, 0, 1}, 1));
    }

    static int findTargetSumWays(int[] a, int s) {
        findSum(a, a.length - 1, s);
        return counter;
    }

    private static void findSum(int[] a, int i, int s) {

        if (i == 0) {
            if (s + a[i] == 0) counter++;
            if (s - a[i] == 0) counter++;
            return;
        }

        findSum(a, i - 1, s + a[i]);
        findSum(a, i - 1, s - a[i]);
    }
}
