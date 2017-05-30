package problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 2016-12-27.
 */
public class IntersectOfTwoArrray2 {
    public int[] intersect(int[] a, int[] nums2) {
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer> list= new ArrayList<>();
        for(int i=0; i<a.length; i++){
            if(!map.containsKey(a[i]))
                map.put(a[i], 1);
            else map.put(a[i], map.get(a[i])+1);
        }
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i)>0){
                list.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        int[] aa=new int[list.size()];
        int ii=0;

        for(Integer intr:list)
            aa[ii++]=intr;
        return aa;



    }
}
