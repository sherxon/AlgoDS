package interviewquestions.hard;

import java.util.Arrays;

/**
 * Created by sherxon on 2/4/17.
 */
public class Diagonaltraverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(
                new int[][]{
                        {1, 2, 3, 4, 5, 6, 7},
                        {8, 9, 10, 11, 12, 13, 14},
                }
        )));
    }

    static int[] findDiagonalOrder(int[][] a) {
        if (a.length == 0 || a[0].length == 0) return new int[0];
        int[] res = new int[a.length * a[0].length];
        int count = 0;
        for (int i = 0; i < a.length + a[0].length - 1; i++) {
            int ii = i;
            int jj = 0;
            if (i >= a.length) {
                jj = i - (a.length - 1);
                ii = a.length - 1;
            }
            if (i % 2 == 0) {
                while (ii > -1 && jj < a[0].length)
                    res[count++] = a[ii--][jj++];

            } else {
                int temp = count + Math.min(ii, a[0].length - jj - 1);
                count = temp + 1;
                while (ii > -1 && jj < a[0].length)
                    res[temp--] = a[ii--][jj++];

            }
        }
        return res;
    }
}
