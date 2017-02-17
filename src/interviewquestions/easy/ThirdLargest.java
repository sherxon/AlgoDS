package interviewquestions.easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by sherxon on 12/26/16.
 */
public class ThirdLargest {
    public int thirdMax(int[] a) {
        if(a.length==0)return 0;
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        boolean b=false;
        for(int i=0; i<a.length; i++){
            if (a[i] == max1 || a[i] == max2 || a[i] == max3) continue;
            if(a[i]>max1){
                max3=max2;//
                max2=max1;//2
                max1=a[i];//5
            } else if (a[i] > max2) {
                max3=max2;//2
                max2=a[i];//3
            } else if (a[i] > max3) {
                max3=a[i];
            }
        }
        return max3!=Long.MIN_VALUE ? Long.valueOf(max3).intValue() : Long.valueOf(max1).intValue();

    }

    public int thirfLargest(int[] a){
        Set<Integer> set= new HashSet<>();
        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
        for (int i : a) {
            if(set.contains(i))continue;
            set.add(i);
            q.add(i);
        }
        if(q.size()>2){
            q.poll();
            q.poll();
        }
        return q.poll();
    }
}
