package problems.medium;

import java.util.*;

/**
 * Created by sherxon on 2016-12-31.
 */
public class Sum3 {
    public static void main(String[] args) {
        List<List<Integer>> lists= new Sum3().threeSum(new int[]{-1,0,1,2,-1,-4,2});
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> list= new ArrayList<>();
        HashMap<Integer, Set<Integer>> map= new HashMap<>();
        for(int i=0; i<a.length; i++){
            int q=i+1;
            int p=a.length-1;
            while(q<p){
                if(a[p]+a[q]>a[i]*-1)p--;
                else if(a[p]+a[q] < a[i]*-1)q++;
                else {
                    List<Integer> l= new ArrayList<>();
                    l.add(a[i]);
                    l.add(a[p]);
                    l.add(a[q]);

                    if(!map.containsKey(a[i]))
                        map.put(a[i], new HashSet<>());
                    if(map.get(a[i]).contains(a[p])){
                        q++;p--;
                        continue;
                    }
                    else map.get(a[i]).add(a[p]);
                    list.add(l);
                }
            }
        }
        return list;
    }
}
