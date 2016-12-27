package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 12/26/16.
 */
public class TwoSum {
    public int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<a.length; i++){
            int s=target-a[i];
            if(map.containsKey(s))
                return new int[]{map.get(s), i};
            map.put(a[i], i);
        }
        return new int[]{};
    }
}
