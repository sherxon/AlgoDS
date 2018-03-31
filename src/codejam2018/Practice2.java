package codejam2018;

import java.util.Scanner;

/**
 * Why Did you create this class? what does it do?
 */
public class Practice2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            builder.append("Case #").append(i + 1).append(": ");
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int max, max2, maxi, maxi2;
            while (true) {
                long sum = 0;
                max = max2 = maxi = maxi2 = -1;
                for (int j = 0; j < a.length; j++) {
                    if (a[j] > max) {
                        maxi2 = maxi;
                        max2 = max;
                        max = a[j];
                        maxi = j;
                    } else if (a[j] > max2) {
                        max2 = a[j];
                        maxi2 = j;
                    }
                    sum += a[j];
                }
                if (max == 0)
                    break;
                a[maxi]--;
                builder.append((char) (maxi + 'A'));

                if (sum == 3 && max == 1) {
                    builder.append(" ");
                    continue;
                }
                if (max > max2) {
                    a[maxi]--;
                    builder.append((char) (maxi + 'A'));
                } else if (maxi2 != -1) {
                    a[maxi2]--;
                    builder.append((char) (maxi2 + 'A'));
                }
                builder.append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());

    }
}
