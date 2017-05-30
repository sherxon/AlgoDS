package problems.easy;

/**
 * Created by sherxon on 2016-12-29.
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(1<<3);
    }

    public int arrangeCoins(int n) {
        return (int) ((-1+(Math.sqrt(8l*n+1)))/2);
    }
}
