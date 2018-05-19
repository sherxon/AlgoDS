package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] a) {
        if (a == null || a.length == 0)
            return a;
        for (int i = 0; i < a.length; i++) {
            rinvert(a, i);
        }
        return a;
    }

    void rinvert(int[][] a, int i) {
        int ii = 0;
        int jj = a[i].length - 1;
        int[] c = a[i];
        while (ii < jj) {
            int temp = c[ii];
            c[ii] = c[jj];
            c[jj] = temp;
            ii++;
            jj--;
        }
        for (int k = 0; k < c.length; k++) {
            c[k] = c[k] == 1 ? 0 : 1;
        }

    }
}
