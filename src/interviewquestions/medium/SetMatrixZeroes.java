package interviewquestions.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/26/17.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 8, 7, 0}};
        setZeroes(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZeroes(int[][] a) {

        boolean firstr = false;
        boolean firstc = false;
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    if (i == 0) firstr = true;
                    if (j == 0) firstc = true;
                    cols.add(j);
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] == 0)
                for (int j = 0; j < a[i].length; j++)
                    a[i][j] = 0;
            else {
                for (Integer col : cols)
                    a[i][col] = 0;
            }
        }

        if (firstr) {
            for (int j = 0; j < a[0].length; j++)
                a[0][j] = 0;
        }
        if (firstc)
            for (int j = 0; j < a.length; j++)
                a[j][0] = 0;

    }
}
