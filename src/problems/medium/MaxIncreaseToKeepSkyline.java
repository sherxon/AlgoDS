package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class MaxIncreaseToKeepSkyline {
    public static void main(String[] args) {
        System.out.println(new MaxIncreaseToKeepSkyline().maxIncreaseKeepingSkyline(
                new int[][] {
                        { 3, 0, 8, 4 },
                        { 2, 4, 5, 7 },
                        { 9, 2, 6, 3 },
                        { 0, 3, 1, 0 }
                }
        ));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int[][] a = new int[2][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                a[0][j] = Math.max(grid[i][j], a[0][j]);
                a[1][i] = Math.max(grid[i][j], a[1][i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += Math.min(a[0][j], a[1][i]) - grid[i][j];
            }
        }
        return sum;
    }
}
