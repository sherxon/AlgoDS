package problems.easy;

/**
 * Created by sherxon on 1/2/17.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int ne=x<0 ? -1 : 1;
        x=Math.abs(x);
        long a=x%10;
        x/=10;
        while (x!=0){
            a*=10;
            a+=x%10;
            if(a < Integer.MIN_VALUE || a > Integer.MAX_VALUE)return 0;
            x/=10;
        }
        return Long.valueOf(a*ne).intValue();
    }

}
