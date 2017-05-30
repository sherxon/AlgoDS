package problems.easy;

/**
 * Created by sherxon on 1/2/17.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if(n<1)return false;
        if(n==1)return true;
        return (n & (n-1)) == 0 && ((Integer.toBinaryString(n).length()-1) %2==0 );

    }
}
