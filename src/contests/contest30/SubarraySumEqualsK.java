package contests.contest30;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 4/29/17.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] a, int k) {
        if(a.length == 0)return 0;
        for(int i=1; i<a.length; i++){
            a[i]+=a[i-1];
        }
        Map<Integer, Integer> map= new HashMap<>();

        int count=0;
        for(int i=0; i<a.length; i++){
            if(a[i]==k)count++;
            Integer p=map.get(a[i]-k);
            if(p!=null)count+=p;
            if(!map.containsKey(a[i]))
                map.put(a[i], 1);
            else
                map.put(a[i], map.get(a[i])+1);
        }

        return count;

    }
}
