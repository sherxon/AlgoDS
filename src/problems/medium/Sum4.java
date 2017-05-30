package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sherxon on 2016-12-31.
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>>lists= new ArrayList<>();
        for (int i = 0; i < a.length-3; i++) {
            if(i>0 && a[i]==a[i-1])continue;
            for (int j = i+1; j <a.length-2; j++) {
                if(j>i+1 && a[j]==a[j-1])continue;
                int q=j+1;
                int p=a.length-1;
                int sum=target-a[i]-a[j];
                while (q<p){
                   if(a[q]+a[p]==sum){
                       lists.add(Arrays.asList(a[i], a[j], a[q], a[p]));
                       while (q<p && a[q]==a[q+1])q++;
                       while (q<p && a[p]==a[p-1])p--;
                       q++;p--;
                   }else if(sum < a[q]+a[p])p--;
                    else q++;
                }
            }
        }
        return lists;
    }

}
