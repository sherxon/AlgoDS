package Timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class Spammer1496 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        Map<String, Integer> map= new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s=in.nextLine();
            if(!map.containsKey(s))
                map.put(s, 1);
            else
                map.put(s, map.get(s)+1);
        }
        for (String s : map.keySet()) {
            if(map.get(s)>1){
                System.out.println(s);
            }
        }
    }
}
