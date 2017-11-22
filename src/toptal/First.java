package toptal;

import java.util.HashSet;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class First {
    public int solution(Point2D[] a) {
        // write your code in Java SE 8
        if (a == null || a.length == 0)
            return 0;
        if (a.length == 1)
            return 1;
        Set<Double> seta = new HashSet<>();
        Set<Double> setb = new HashSet<>();
        Set<Double> setc = new HashSet<>();
        Set<Double> setd = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            double d = Integer.valueOf(a[i].x).doubleValue() / Integer.valueOf(a[i].y).doubleValue();
            int x = a[i].x;
            int y = a[i].y;
            if (x > 0 && y > 0) {
                seta.add(d);
            } else if (x < 0 && y > 0) {
                setb.add(d);
            } else if (x < 0 && y < 0) {
                setc.add(d);
            } else {
                setd.add(d);
            }
        }

        return seta.size() + setb.size() + setc.size() + setd.size();
    }

    class Point2D {
        public int x;
        public int y;
    }
}
