package problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 2016-12-28.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] a=s.toCharArray();
        Map<Character, Character> map=new HashMap<>();
        Map<Character, Character> map2=new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(!map.containsKey(a[i])){
                if(map2.containsKey(t.charAt(i)))
                    return false;
                map.put(a[i], t.charAt(i));
                map2.put(t.charAt(i), a[i]);
            }
            else if(map.get(a[i])!=t.charAt(i))
                return false;
        }
        return true;
    }
}
