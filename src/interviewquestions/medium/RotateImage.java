package interviewquestions.medium;

/**
 * Created by sherxon on 2/2/17.
 */

/**
 * Rotate matrix by 90 degree in place. Rotating to other degrees such 180 270 is also similar to this
 */
public class RotateImage {

    /**
     * The first solution is setting 4 rotated values in its own place.
     */
    void rotate(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - j - 1][i];
                a[n - j - 1][i] = a[n - i - 1][n - j - 1];
                a[n - i - 1][n - j - 1] = a[j][n - i - 1];
                a[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * This is the second way. The idea is first reverse up to down, then swap the symmetry
     */
    public void rotate2(int[][] a) {

    }

}
