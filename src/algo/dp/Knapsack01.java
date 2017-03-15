package algo.dp;

/**
 * Created by sherxon on 3/15/17.
 */
public class Knapsack01 {
    public static void main(String[] args) {
        knapsack(new int[]{1, 4, 5, 7}, new int[]{1, 3, 4, 5}, 7);
    }

    static void knapsack(int[] values, int[] weights, int k) {
        int[][] a = new int[values.length][k + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if (i == 0) {
                    if (weights[i] <= j)
                        a[i][j] = values[i];
                } else {
                    if (j < weights[i])
                        a[i][j] = a[i - 1][j];
                    else
                        a[i][j] = Math.max(a[i - 1][j], values[i] + a[i - 1][j - weights[i]]);
                }
            }
        }
        print(a);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


}
