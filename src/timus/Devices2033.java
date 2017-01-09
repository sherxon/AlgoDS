package timus;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sherxon on 12/9/16.
 */
public class Devices2033 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map= new HashMap<>(6);
        HashMap<String, Integer> price= new HashMap<>(6);
        String s=null;
        for (int i = 0; i < 6; i++) {
            in.next();
            s=in.next();
            if(!map.containsKey(s))
                map.put(s, 1);
            else
                map.put(s, map.get(s)+1);

            int cost=Integer.parseInt(in.next());
            if(!price.containsKey(s) || price.get(s)>cost)
                price.put(s, cost);

        }
        String ss=null;
        int max=0;
        for (String s1 : map.keySet()) {
            if(map.get(s1)>max){
                max=map.get(s1);
                ss=s1;
            }
        }
        int min=Integer.MAX_VALUE;
        String sss=null;
        for (String s1 : map.keySet()) {
            if(max==map.get(s1) && price.get(s1)<min){
                min=price.get(s1);
                sss=s1;
            }
        }
        System.out.println(sss);
    }
}
