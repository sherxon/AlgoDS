package problems.easy;

/**
 * Created by sherxon on 2016-12-29.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<4)return n;
        int f1=1;
        int f2=1;
        int f3=f1+f2;
        for(int i=1; i<n; i++){
            f1=f3;
            f3=f1+f2;
            f2=f1;
        }
        return f2;
    }
}
