package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class LargestPlusSign {
    public static void main(String[] args) {
        System.out.println(orderOfLargestPlusSign(2, new int[][] {
                { 0, 0 },
                { 0, 1 },
                { 1, 0 },
                { 1, 1 },
                }));
        System.out.println(orderOfLargestPlusSign(5, new int[][] {
                { 4, 2 },
                }));
        System.out.println(orderOfLargestPlusSign(3, new int[][] {
                { 0, 0 },
                }));
    }

    static public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][][] a = new int[N][N][5];

        for (int i = 0; i < mines.length; i++) {
            a[mines[i][0]][mines[i][1]][0] = 1;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int ii = a.length - 1 - i;
                int jj = a.length - 1 - j;

                if (a[i][j][0] == 0) {
                    a[i][j][1] = Math.max(a[i][j][1], 1);
                    a[i][j][2] = Math.max(a[i][j][2], 1);
                    a[i][j][3] = Math.max(a[i][j][3], 1);
                    a[i][j][4] = Math.max(a[i][j][4], 1);
                }
                if (a[ii][jj][0] == 0) {
                    a[ii][jj][1] = Math.max(a[ii][jj][1], 1);
                    a[ii][jj][2] = Math.max(a[ii][jj][2], 1);
                    a[ii][jj][3] = Math.max(a[ii][jj][3], 1);
                    a[ii][jj][4] = Math.max(a[ii][jj][4], 1);
                }

                if (a[i][j][0] == 0 && j > 0) {
                    a[i][j][1] = a[i][j - 1][1] + 1;
                }
                if (a[i][j][0] == 0 && i > 0) {
                    a[i][j][2] = a[i - 1][j][2] + 1;
                }
                if (a[ii][jj][0] == 0 && jj < a.length - 1) {
                    a[ii][jj][3] = a[ii][jj + 1][3] + 1;
                }
                if (a[ii][jj][0] == 0 && ii < a.length - 1) {
                    a[ii][jj][4] = a[ii + 1][jj][4] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j][0] == 0) {
                    int min = Math.min(a[i][j][1], a[i][j][2]);
                    int min2 = Math.min(a[i][j][3], a[i][j][4]);
                    max = Math.max(max, Math.min(min, min2));
                }
            }
        }
        return max;
    }
}
