package problems.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Why Did you create this class? what does it do?
 */
public class CarFleet {
    public static void main(String[] args) {
        System.out.println(new CarFleet().carFleet(10,
                new int[] { 0, 2, 4 },
                new int[] { 2, 3, 1 }));
        System.out.println(new CarFleet().carFleet(10,
                new int[] { 6, 8 },
                new int[] { 3, 2 }));

        System.out.println(new CarFleet().carFleet(12,
                new int[] { 10, 8, 0, 5, 3 },
                new int[] { 2, 4, 1, 1, 3 }));
    }

    public int carFleet(int target, int[] position, int[] speed) {

        if (speed == null || speed.length == 0)
            return 0;
        if (speed.length == 1)
            return 1;

        int r = 0;
        Pair[] pairs = new Pair[speed.length];

        for (int i = 0; i < speed.length; i++) {
            pairs[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.pos));
        double[] a = new double[pairs.length];
        for (int i = pairs.length - 1; i >= 0; i--) {
            a[i] = (target - pairs[i].pos * 1.0) / pairs[i].speed;
        }
        boolean infleet = false;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                r += infleet ? 0 : 1;
                infleet = false;
                continue;
            }
            if (!infleet) {
                r++;
                infleet = true;
            }
            a[i - 1] = Math.max(a[i - 1], a[i]);
        }

        r += (a[0] > a[1] ? 1 : 0);
        return r;
    }

    class Pair {
        int pos;
        int speed;

        Pair(int p, int s) {
            pos = p;
            speed = s;
        }
    }
}
