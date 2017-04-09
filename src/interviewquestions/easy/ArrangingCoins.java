package interviewquestions.easy;

/**
 * Created by sherxon on 2016-12-29.
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(1<<3);
    }

    public int arrangeCoins(int n) {
        long count= (-1 + ((long)Math.sqrt(1+4*2.0*n)))/2;
        return Long.valueOf(count).intValue();
    }
}
