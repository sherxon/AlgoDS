package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Sherali Obidov.
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> list= new ArrayList<>();
        if(arr==null || arr.size()==0 || k==0)return list;

        PriorityQueue<Integer> q= new PriorityQueue<>((a, b)-> {
            int d= (Math.abs(x-a))-(Math.abs(x-b));
            if(d==0)return a-b;
            return d;
        });
        q.addAll(arr);
        if(q.size()<k)return list;
        for(int i=0; i<k; i++){
            list.add(q.remove());
        }
        Collections.sort(list);
        return list;
    }
}
