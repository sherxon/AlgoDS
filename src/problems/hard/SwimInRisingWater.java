package problems.hard;

import java.util.Arrays;

/**
 * Why Did you create this class? what does it do?
 */
public class SwimInRisingWater {

    public int swimInWater(int[][] grid) {
        int[][] a = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(a[i], Integer.MAX_VALUE);
        }
        int m = a.length;
        int n = a[0].length;
        a[0][0] = grid[0][0];
        for (int k = 0; k < m + n; k++) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int min = a[i][j];
                    if (i > 0) {
                        min = Math.min(min, a[i - 1][j]);
                    }
                    if (j > 0) {
                        min = Math.min(min, a[i][j - 1]);
                    }
                    if (i < a.length - 1) {
                        min = Math.min(min, a[i + 1][j]);
                    }
                    if (j < a[i].length - 1) {
                        min = Math.min(min, a[i][j + 1]);
                    }
                    a[i][j] = Math.max(min, grid[i][j]);
                }
            }

        }
        return a[n - 1][m - 1];
    }
}
