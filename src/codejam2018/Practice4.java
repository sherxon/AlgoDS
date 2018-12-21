package codejam2018;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class Practice4 {

    static long k = 0;
    static long y = 0;
    static long z = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            builder.append("Case #").append(i + 1).append(": ");
            long n = in.nextLong();
            k = in.nextLong();
            y = z = 0;
            go(new Pair(1, n));
            builder.append(y).append(" ").append(z).append("\n");
        }
        System.out.println(builder);
    }

    private static class Pair implements Comparable<Pair> {
        long from, to;

        public Pair(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override public int compareTo(Pair p) {
            long diff = (to - from) - (p.to - p.from);
            if (diff > 0)
                return -1;
            else if (diff < 0)
                return 1;
            return (p.from - from) < 0 ? 1 : -1;
        }
    }

    private static void go(Pair pair1) {
        if (k <= 0)
            return;

        Queue<Pair> lf = new PriorityQueue<>();

        lf.add(pair1);
        while (!lf.isEmpty()) {
            k--;
            Pair pair = lf.remove();
            long mid = pair.from + (pair.to - pair.from) / 2;
            if (k == 0 || pair.to < pair.from) {
                y = Math.max(mid - pair.from, pair.to - mid);
                z = Math.min(mid - pair.from, pair.to - mid);
                return;
            }

            Pair left = new Pair(pair.from, mid - 1);
            Pair right = new Pair(mid + 1, pair.to);
            lf.add(left);
            lf.add(right);

        }
    }
}
