package problems.easy;

/**
 * Created by sherxon on 1/29/17.
 */
public class BestTimeToBuyandSellStock2 {

    public int maxProfit(int[] a) {
        if (a.length < 2) return 0;
        int total = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) total += a[i] - a[i - 1];
        }
        return total;
    }

}
