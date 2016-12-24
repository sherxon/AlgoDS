package leetcode;

/**
 * Created by sherxon on 12/23/16.
 */
public class HammingDistance {
    public static int hammingDistance(int x,int y){
        return Integer.bitCount(x^y);
    }
}
