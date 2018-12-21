package problems.hard;

/**
 * Why Did you create this class? what does it do?
 */
public class ReachingPoints {
    public static void main(String[] args) {
        System.out.println(reachingPoints(1, 3, 11, 18));
        System.out.println(reachingPoints(1, 2, 1000000000, 2));
        System.out.println(reachingPoints(1, 2, 999999999, 2));
    }

    static public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty)
            return false;

        while (sx <= tx && sy <= ty) {
            if (sx == tx && sy == ty)
                return true;

            if (sx == tx) {
                return (ty - sy) % sx == 0;
            } else if (sy == ty) {
                return (tx - sx) % sy == 0;
            }
            if (tx > ty) {
                tx -= ty;
            } else {
                ty -= tx;
            }
        }

        return false;
    }
}
