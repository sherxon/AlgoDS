package interviewquestions.medium;

/**
 * Created by sherxon on 1/28/17.
 */
public class GameofLife {

    static void gameOfLife(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int al = getAliveN(a, i, j);
                if (a[i][j] == 1 && (al < 2 || al > 3))
                    a[i][j] = -1;
                else if (a[i][j] == 0 && al == 3)
                    a[i][j] = 2;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == -1) a[i][j] = 0;
                else if (a[i][j] == 2) a[i][j] = 1;
            }
        }

    }

    private static int getAliveN(int[][] a, int i, int j) {
        int count = 0;
        if (j < a[i].length - 1 && (a[i][j + 1] == 1 || a[i][j + 1] == -1)) count++;
        if (j > 0 && (a[i][j - 1] == 1 || a[i][j - 1] == -1)) count++;
        if (i > 0 && (a[i - 1][j] == 1 || a[i - 1][j] == -1)) count++;
        if (i < a.length - 1 && (a[i + 1][j] == 1 || a[i + 1][j] == -1)) count++;

        if (i < a.length - 1 && j < a[i].length - 1 && (a[i + 1][j + 1] == 1 || a[i + 1][j + 1] == -1)) count++;
        if (i < a.length - 1 && j > 0 && (a[i + 1][j - 1] == 1 || a[i + 1][j - 1] == -1)) count++;
        if (i > 0 && j > 0 && (a[i - 1][j - 1] == 1 || a[i - 1][j - 1] == -1)) count++;
        if (i > 0 && j < a[i].length - 1 && (a[i - 1][j + 1] == 1 || a[i - 1][j + 1] == -1)) count++;

        return count;
    }
}
