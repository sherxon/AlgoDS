package problems.easy;

/**
 * famous max area island problem
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] a) {
        if (a.length == 0 || a[0].length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    max = Math.max(max, count(a, i, j));
                }
            }
        }
        return max;
    }

    int count(int[][] a, int i, int j) {
        if (i >= a.length || i < 0 || j >= a[i].length || j < 0)
            return 0;
        if (a[i][j] == 0)
            return 0;
        a[i][j] = 0;
        return count(a, i + 1, j) + count(a, i - 1, j) + count(a, i, j + 1) + count(a, i, j - 1) + 1;
    }
}
