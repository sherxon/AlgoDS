package problems.medium;

/**
 * Created by sherxon on 1/28/17.
 */
public class GameofLife {
    public void gameOfLife(int[][] a) {
        if (a == null || a.length == 0)
            return;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int count = count(a, i, j);
                if (isAlive(a, i, j) && count < 2)
                    a[i][j] = -1;
                else if (isAlive(a, i, j) && count > 3)
                    a[i][j] = -1;
                else if (isAlive(a, i, j))
                    a[i][j] = 1;
                else if (!isAlive(a, i, j) && count == 3)
                    a[i][j] = -2;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == -1)
                    a[i][j] = 0;
                else if (a[i][j] == -2)
                    a[i][j] = 1;
            }
        }

    }

    boolean isAlive(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[i].length)
            return false;
        return a[i][j] == 1 || a[i][j] == -1;
    }

    int count(int[][] a, int i, int j) {
        int count = 0;
        if (isAlive(a, i - 1, j - 1))
            count++;
        if (isAlive(a, i - 1, j))
            count++;
        if (isAlive(a, i - 1, j + 1))
            count++;
        if (isAlive(a, i, j - 1))
            count++;
        if (isAlive(a, i, j + 1))
            count++;
        if (isAlive(a, i + 1, j - 1))
            count++;
        if (isAlive(a, i + 1, j))
            count++;
        if (isAlive(a, i + 1, j + 1))
            count++;
        return count;
    }
}
