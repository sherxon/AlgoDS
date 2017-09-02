package problems.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Sherali Obidov.
 */
// there is faster solution than implementing real scheduler
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0)return 0;
        int[] a= new int[26];

        if(n==0)return tasks.length;

        for(int i=0; i<tasks.length; i++)
            a[tasks[i]-'A']++;

        int count=0;

        Map<Integer, Integer> map= new HashMap<>(n);
        LinkedList<Integer> list= new LinkedList<>();

        while(true){

            if(list.size() > n){
                int t=list.removeFirst();
                if(map.get(t)==1)
                    map.remove(t);
                else
                    map.put(t, map.get(t)-1);
                //map.put(t, map.getOrDefault(t, 0)-1);

            }

            int next=next(a, map);
            if(next==-2) break;

            map.put(next, map.getOrDefault(next, 0)+1);
            list.addLast(next);

            count++;
        }
        return count;
    }
    int next(int[] a, Map<Integer, Integer> map){
        int temp=0;
        int max=0;
        int maxi=-1;
        for(int i=0; i<a.length; i++){
            temp+=a[i];
            if(a[i] > 0 && !map.containsKey(i)){
                if(max<a[i]){
                    max=a[i];
                    maxi=i;
                }
            }
        }
        if(maxi>-1){
            a[maxi]--;
            return maxi;
        }
        return temp==0 ? -2 : -1;
    }
}
