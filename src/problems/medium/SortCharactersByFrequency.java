package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sherxon on 2016-12-31.
 */
// this is O(NlgN)
// this also can be solved O(n)
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println((char)90);
    }
    public String frequencySort(String s) {
        if(s==null)return null;
        if(s.length()<3)return s;

        String r=null;
        HashMap<Character, Pair> map= new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c))map.put(c, new Pair(c, 1));
            else map.get(c).count++;
        }
        List<Pair> list=new ArrayList<>(map.values());
        Collections.sort(list);
        StringBuilder builder= new StringBuilder();
        for (Pair pair : list)
            for (int i = 1; i <pair.count ; i++)
                builder.append(pair.c);
        return builder.toString();
    }
    private class Pair implements Comparable<Pair>{
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return o.count-this.count;
        }
    }
}
