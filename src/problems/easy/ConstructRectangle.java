package problems.easy;

/**
 * Created by sherxon on 1/22/17.
 */
public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        if (area < 1) return new int[0];
        if (area == 1) return new int[]{1, 1};
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        int ii = 1;
        for (int i = 2; i <= area / 2; i++) {
            if (area % i == 0) {
                if (diff > Math.abs(area / i - i)) {
                    diff = Math.abs(area / i - i);
                    ii = i;
                }
            }
        }
        return new int[]{Math.max(ii, area / ii), Math.min(ii, area / ii)};
    }
}
