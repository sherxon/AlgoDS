package problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 2016-12-27.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set=new HashSet<>();

        for(int i:nums1)
            if(!set.contains(i))set.add(i);
        Set<Integer> set2=new HashSet<>();
        for(int i:nums2)
            if(set.contains(i))set2.add(i);
        int[] a= new int[set2.size()];
        int i=0;
        for(Integer inte: set2){
            a[i++]=inte;
        }
        return a;

    }
}
