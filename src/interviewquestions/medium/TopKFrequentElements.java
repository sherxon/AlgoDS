package interviewquestions.medium;

import java.util.*;

/**
 * Created by sherxon on 1/4/17.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] a, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i:a){
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i)+1);
        }
        TreeMap<Integer, Set<Integer>> tr= new TreeMap<>((c, b)->b.compareTo(c));
        for(Integer ii:map.keySet()){
            Integer val=map.get(ii);
            if(!tr.containsKey(val))
                tr.put(val, new HashSet<>());
            tr.get(val).add(ii);
        }

        int i=0;
        List<Integer> list= new ArrayList<>();
        for (Integer integer : tr.keySet()) {
            if(i>=k)break;
            for(Integer num:tr.get(integer)){
                if(i>=k)break;
                list.add(num);
                i++;
            }


        }
        return list;

    }
}
