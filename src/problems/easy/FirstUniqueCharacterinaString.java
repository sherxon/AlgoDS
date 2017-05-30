package problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 1/1/17.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        char[] a=s.toCharArray();
        Map<Character, Boolean> map= new HashMap<>();
        for(char c: a){
            if(map.containsKey(c))map.put(c, false);
            else map.put(c, true);
        }

        for(int i=0; i<a.length; i++){
            if(map.get(a[i]))return i;
        }
        return -1;
    }
}
