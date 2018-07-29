package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] a) {
        int result = 0;
        int count = 0;
        int firstZeros = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                count++;
            } else {
                result = Math.max(result, count / 2 + count % 2);
                if (firstZeros == 0 && a[0] == 0)
                    firstZeros = count;
                count = 0;
            }
        }
        int r = 0;
        r += (a[0] < a[1] ? 1 : 0);
        return Math.max(Math.max(result, firstZeros), count);

    }
}
