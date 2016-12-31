package InterviewQuestions.Medium;

import java.util.Arrays;

/**
 * Created by sherxon on 12/31/16.
 */
public class HIndex {
    public int hIndex(int[] a) {
        if(a==null || a.length==0)return 0;
        if(a.length==1 && a[0]==0)return 0;
        Arrays.sort(a);
        int max=0;
        for(int i=a.length-1; i>-1; i--){
            if(a[i]>max)max++;
        }
        return max;
    }
}
