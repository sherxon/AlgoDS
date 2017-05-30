package problems.easy;

/**
 * Created by sherxon on 2016-12-29.
 */
public class HouseRobber {
    public int rob(int[] a) {
        if(a==null || a.length==0)return 0;
        if(a.length==1) return a[0];
        a[1]=Math.max(a[0], a[1]);
        for(int i=2; i<a.length; i++){
            a[i]=Math.max(a[i]+a[i-2], a[i-1]);
        }

        return a[a.length-1];
    }
}
