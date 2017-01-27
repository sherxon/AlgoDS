package interviewquestions.medium;

/**
 * Created by sherxon on 1/26/17.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {0, 6, 7, 8}, {9, 8, 7, 6}};
        setZeroes(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZeroes(int[][] a) {

        boolean first = a[0][0] == 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] == 0)
                for (int j = 0; j < a[i].length; j++)
                    a[i][j] = 0;
        }
        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] == 0 && (i != 0 || first))
                for (int j = 0; j < a.length; j++)
                    a[j][i] = 0;
        }
        if (a[0][0] == 0 && false) {
            for (int j = 0; j < a[0].length; j++)
                a[0][j] = 0;

            if (first)
                for (int j = 0; j < a.length; j++)
                    a[j][0] = 0;

        }

    }
}
