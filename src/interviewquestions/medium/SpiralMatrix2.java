package interviewquestions.medium;

import java.util.Arrays;

/**
 * Created by sherxon on 2/10/17.
 */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        generateMatrix(2);
    }

    static int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int count = 1;
        for (int i = 0; i < a.length / 2 + 1; i++) {

            for (int j = i; j < a[0].length - i && count <= n * n; j++) {
                a[i][j] = count++;
            }
            for (int j = i + 1; j < a.length - i && count <= n * n; j++) {
                a[j][a[0].length - i - 1] = count++;
            }
            for (int j = i + 1; j < a[0].length - i && count <= n * n; j++) {
                a[a.length - i - 1][a[0].length - j - 1] = count++;
            }
            for (int j = i + 1; j < a.length - i - 1 && count <= n * n; j++) {
                a[a.length - j - 1][i] = count++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        return a;
    }
}
