package problems.easy;

/**
 * Created by sherxon on 1/7/17.
 */
public class NumberComplement {

    public static int findComplement(int i) {
        int ones = (Integer.highestOneBit(i) << 1) - 1;
        return i ^ ones;
    }
}
