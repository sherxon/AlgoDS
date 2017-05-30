package problems.medium;

/**
 * Created by sherxon on 2016-12-30.
 */
public class MinimumSizeSubArray {
    public static void main(String[] args) {
        new MinimumSizeSubArray().minSubArrayLen(9, new int[]{3, 2, 1, 1, 1, 1});
    }

    public int minSubArrayLen(int s, int[] a) {
        if(a==null || a.length==0)return 0;

        for (int i = 1; i < a.length; i++)
                a[i]+=a[i-1];

        int i=-1;
        int j=0;
        int min=a.length+1;
        int ai=0;
        while(j<a.length){
            if(i!=-1)ai=a[i];
            if(a[j]-ai>=s){
                System.out.println(i + " " + j);
                min=Math.min(j-i, min);
                i++;
            }else j++;
        }
        min = min==a.length+1 ? 0 : min;
        return min;
    }
}
