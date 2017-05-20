package problems.medium;

/**
 * Created by sherxon on 1/20/17.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[][] a = new int[m][n];

        for (int i = 0; i < a.length; i++)
            a[i][0] = 1;
        for (int i = 0; i < a[0].length; i++)
            a[0][i] = 1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                a[i][j] = a[i][j - 1] + a[i - 1][j];
            }
        }
        return a[m - 1][n - 1];
    }
}
