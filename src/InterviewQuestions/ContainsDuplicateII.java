package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 12/26/16.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i]) && i- map.get(a[i]) <=k)return true;
            map.put(a[i], i);
        }

        return false;
    }
}
