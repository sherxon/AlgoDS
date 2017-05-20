package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 4/15/17.
 */
public class ShortestWordDistance2 {

    Map<String, Set<Integer>> map= new HashMap<>();

    public ShortestWordDistance2(String[] words) {
        for(int i=0; i<words.length; i++){
            if(!map.containsKey(words[i]))
                map.put(words[i], new HashSet<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int min=Integer.MAX_VALUE;
        for(Integer i:map.get(word1)){
            for(Integer j:map.get(word2)){
                min=Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}
