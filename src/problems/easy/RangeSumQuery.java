package problems.easy;

/**
 * Created by sherxon on 2016-12-29.
 */
public class RangeSumQuery {
    int a[];
    public RangeSumQuery(int[] nums) {
        a=nums;
        for(int i=1;i<a.length; i++)
            a[i]+=a[i-1];

    }

    public int sumRange(int i, int j) {
        if(i==0)return a[j];
        return a[j]-a[i-1];
    }
}
