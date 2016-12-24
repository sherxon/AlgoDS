package Timus;

import java.util.*;

/**
 * Created by sherxon on 11/30/16.
 */
public class TopologicalSorting1280 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s=in.nextLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        Map<Integer, Set<Integer>> map =new HashMap<>();
        for (int i = 0; i < m; i++) {
            s=in.nextLine().split(" ");
            int k=Integer.parseInt(s[0]);
            int l=Integer.parseInt(s[1]);
            if(!map.containsKey(k))
                map.put(k, new HashSet<>());
            map.get(k).add(l);
        }

        int[] a= new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }

        boolean r=false;
        for (Integer key : map.keySet()) {
            int index=indexOf(key, a, 0);
            for (Integer value : map.get(key)) {
                int index2=indexOf(value, a, index+1);
                if(index2<0){
                    r=true;
                    break;
                }
            }
            if(r)break;
        }
        System.out.println(r ? "NO" : "YES" );
    }

    private static int indexOf(Integer key, int[] a, int fromIndex) {
        for (int i = fromIndex; i < a.length; i++) {
            if(key==a[i])return i;
        }
        return -1;
    }
}
