package problems.medium;

/**
 * Created by sherxon on 1/12/17.
 */
public class WaterAndJugProblem {


    boolean canMeasureWater(int x, int y, int z) {
        if (x == z || y == z) return true;
        if (x == 0 || y == 0 || x + y < z) return false;
        int a = getGCD(x, y);
        return z % a == 0;
    }

    int getGCD(int x, int y) {
        if (y == 0) return x;
        return getGCD(y, x % y);
    }
}
