package problems.medium;

import java.util.Arrays;

/**
 * Created by sherxon on 2016-12-31.
 */
public class HIndex {
    // O(NlgN) solution
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
//O(N) solution
    public int hIndex2(int[] a){
        int max=0;
        int b[] = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            if(a[i]>=b.length)b[b.length-1]++;
            else b[a[i]]++;
        }
        for (int i = b.length-2; i >=0; i--)
            b[i]+=b[i+1];
        for (int i = b.length-1; i >=0; i--){
            if(b[i]>=i){
                return i;
            }
        }

        return max;

    }
}
