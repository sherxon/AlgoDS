package codejam2018;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Why Did you create this class? what does it do?
 */
public class Practice3 {
    public static void main(String[] args) {
        NumberFormat formatter = new DecimalFormat("#0.000000");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            builder.append("Case #").append(i + 1).append(": ");
            long dest = in.nextLong();
            int horses = in.nextInt();
            double max = Double.NEGATIVE_INFINITY;
            for (int j = 0; j < horses; j++) {
                long pos = in.nextLong();
                long speed = in.nextLong();
                max = Math.max((dest - pos) * 1.0 / speed, max);
            }
            builder.append(formatter.format(dest / max));
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
