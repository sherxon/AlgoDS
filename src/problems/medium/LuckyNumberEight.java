package problems.medium;

import java.util.Scanner;

/**
 * Created by sherxon on 1/13/17.
 */
public class LuckyNumberEight {
    static long counter = 0;
    static long mod = (long) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String number = in.next();
        boolean[] a = new boolean[number.length()];
        subsets(a, number, n);
        System.out.println(counter);
    }

    private static void subsets(boolean[] a, String number, int n) {
        if (n == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length; i++)
                if (a[i]) sb.append(number.charAt(i));

            if (sb.length() > 0) {
                String last3;
                if (sb.length() > 2)
                    last3 = sb.substring(sb.length() - 3, sb.length());
                else
                    last3 = sb.toString();
                if (Integer.parseInt(last3) % 8 == 0) {
                    counter++;
                    counter = counter % mod;
                }
            }

            return;
        }

        a[n - 1] = true;
        subsets(a, number, n - 1);

        a[n - 1] = false;
        subsets(a, number, n - 1);
    }
}
