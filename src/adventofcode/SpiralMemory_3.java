package adventofcode;

/**
 * Why Did you create this class? what does it do?
 */
public class SpiralMemory_3 {
    public static void main(String[] args) {
        //        System.out.println(solve(277678));
        //        System.out.println(solve(1024));
        //        System.out.println(solve(1));
        //        System.out.println(solve(12));
        //        System.out.println(solve(23));
        //        System.out.println(solve(26));
        System.out.println(solve2(277678));
    }

    private static int solve2(int n) {
        int d = 2;
        int[][] a = new int[101][101];
        int i = 50;
        int j = 50;
        int k = -1;
        int c = 2;
        a[i][j] = 1;
        a[i][j + 1] = 1;
        a[i - 1][j + 1] = 2;
        j++;
        i--;
        while (d <= n) {
            if (k == 1) { // go right
                for (int l = 0; l < c; l++) {
                    a[i][++j] = a[i][j + 1] + a[i][j - 1] + a[i + 1][j] + a[i - 1][j] +
                                a[i + 1][j + 1] + a[i - 1][j - 1] + a[i + 1][j - 1] + a[i - 1][j + 1];
                    d = Math.max(d, a[i][j]);
                    if (d > n)
                        break;
                }
                k = -2;
            } else if (k == -2) { // go up
                for (int l = 0; l < c; l++) {
                    a[--i][j] = a[i][j + 1] + a[i][j - 1] + a[i + 1][j] + a[i - 1][j] +
                                a[i + 1][j + 1] + a[i - 1][j - 1] + a[i + 1][j - 1] + a[i - 1][j + 1];
                    d = Math.max(d, a[i][j]);
                    if (d > n)
                        break;
                }
                c++;
                k = -1;
            } else if (k == -1) { // go left
                for (int l = 0; l < c; l++) {
                    a[i][--j] = a[i][j + 1] + a[i][j - 1] + a[i + 1][j] + a[i - 1][j] +
                                a[i + 1][j + 1] + a[i - 1][j - 1] + a[i + 1][j - 1] + a[i - 1][j + 1];
                    d = Math.max(d, a[i][j]);
                    if (d > n)
                        break;
                }
                k = 2;
            } else { // go down
                for (int l = 0; l < c; l++) {
                    a[++i][j] = a[i][j + 1] + a[i][j - 1] + a[i + 1][j] + a[i - 1][j] +
                                a[i + 1][j + 1] + a[i - 1][j - 1] + a[i + 1][j - 1] + a[i - 1][j + 1];
                    d = Math.max(d, a[i][j]);
                    if (d > n)
                        break;
                }
                k = 1;
                c++;
            }
            printa(a, c + 4);
            System.out.println();
            System.out.println("#####################");
            System.out.println();
        }
        return d;
    }

    private static void printa(int[][] a, int x) {
        for (int i = 50 - x; i < 50 + x; i++) {
            for (int j = 50 - x; j < 50 + x; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int solve(int n) {
        if (n == 1)
            return 0;
        int k = 0;
        int d = 1;
        int i = 1;
        while (d < n) {
            k += 8;
            d += k;
            i += 2;
        }
        int ii, jj;
        int lbc = d - i + 1;
        int luc = lbc - i + 1;
        int ruc = luc - i + 1;
        if (n <= d && n >= lbc) {
            ii = i - 1;
            jj = n - lbc;
        } else if (n <= lbc && n >= luc) {
            ii = n - luc;
            jj = 0;
        } else if (n <= luc && n >= ruc) {
            ii = 0;
            jj = luc - n;
        } else {
            ii = ruc - n;
            jj = i - 1;
        }
        return Math.abs(ii - i / 2) + Math.abs(jj - i / 2);
    }
}
