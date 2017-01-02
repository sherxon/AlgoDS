package InterviewQuestions.Medium;

/**
 * Created by sherxon on 1/2/17.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] a) {
        if(a==null || a.length==0)return 0;
        int maxSoFar=a[0];
        int maxEndingHere=a[0];
        for (int i = 1; i < a.length; i++) {
            maxEndingHere=Math.max(maxEndingHere+a[i], a[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
