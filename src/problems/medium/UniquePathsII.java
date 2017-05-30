package problems.medium;

/**
 * Created by sherxon on 1/20/17.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        if (m == 0 || a[0].length == 0) return 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 1) break;
            a[i][0] = -1;
        }
        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] == 1) break;
            a[0][i] = -1;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j] == 1 || (a[i][j - 1] == 1 && a[i - 1][j] == 1)) continue;
                if (a[i][j - 1] == 1) a[i][j] = a[i - 1][j];
                else if (a[i - 1][j] == 1) a[i][j] = a[i][j - 1];
                else a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        return (-1 * a[a.length - 1][a[0].length - 1]) < 0 ? 0 : -1 * a[a.length - 1][a[0].length - 1];

    }
}
