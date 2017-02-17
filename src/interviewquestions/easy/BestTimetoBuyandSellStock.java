package interviewquestions.easy;

/**
 * Created by sherxon on 12/26/16.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] a) {
        if(a.length==0)return 0;
        int max = 0;
        int min=a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i] - min);
            min = Math.min(min, a[i]);
        }
        return max;

    }
}
