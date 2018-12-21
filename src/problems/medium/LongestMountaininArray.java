package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class LongestMountaininArray {
    public int longestMountain(int[] a) {
        if (a == null || a.length < 3)
            return 0;
        int max = 0;
        for (int i = 1; i < a.length - 1; i++) {
            int ii = i;
            int jj = i;
            while (jj < a.length - 1 && a[jj] > a[jj + 1]) {
                jj++;
            }
            while (ii > 0 && a[ii] > a[ii - 1]) {
                ii--;
            }
            if (ii != i && jj != i)
                max = Math.max(max, jj - ii);
        }
        return max == 0 ? 0 : max + 1;
    }
}
