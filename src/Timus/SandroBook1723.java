package Timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sherxon on 12/5/16.
 */
public class SandroBook1723 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map= new HashMap<>();
        char[] a=in.nextLine().toCharArray();
        for (char c : a) {
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c)+1);
        }
        int max=0;
        char c=0;
        for (Character character : map.keySet()) {
            if(max<map.get(character)){
                max=map.get(character);
                c=character;
            }
        }
        System.out.println(c);
    }
}
