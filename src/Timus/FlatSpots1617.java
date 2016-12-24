package Timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sherxon on 12/6/16.
 */
public class FlatSpots1617 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        Map<Integer, Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            int k=in.nextInt();
            if (!map.containsKey(k))
                map.put(k, 1);
            else map.put(k, map.get(k)+1);
        }
        System.out.println(map.values().stream().filter(s->s/4>0).
                reduce(0, (a,b)->a+b/4).intValue());
    }
}
