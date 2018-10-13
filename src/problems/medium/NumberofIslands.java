package problems.medium;

/**
 * Created by sherxon on 1/21/17.
 */
public class NumberofIslands {
    public int numIslands(char[][] a) {
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == '1') {
                    countIt(a, i, j);
                    counter++;
                }
            }
        }
        return counter - 1;
    }

    void countIt(char[][] a, int i, int j) {
        if (i >= 0 && i < a.length && j >= 0 && j < a[i].length && a[i][j] == '1')
            a[i][j] = '0';
        else
            return;
        countIt(a, i + 1, j);
        countIt(a, i, j + 1);
        countIt(a, i - 1, j);
        countIt(a, i, j - 1);
    }
}
