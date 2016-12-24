package Timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sherxon on 12/5/16.
 */
public class Hieroglyphs {
    public static void main(String[] args) {
        FastReader reader= new FastReader();
        int n=Integer.parseInt(reader.nextLine());
        Map<Character, Set<Character>> setMap= new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s=reader.nextLine();
            if(!setMap.containsKey(s.charAt(0)))
                setMap.put(s.charAt(0), new HashSet<>());
            setMap.get(s.charAt(0)).add(s.charAt(1));
        }
        char r=reader.nextLine().charAt(0);
        if(setMap.containsKey(r))
        for (Character character : setMap.get(r)) {
            System.out.println(String.valueOf(r)+String.valueOf(character));
        }
    }
    public static class FastReader {
        BufferedReader bf;
        StringTokenizer st;


        public FastReader() {
            bf=new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine(){
            String st="";
            try {
                st=bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  st;
        }
        String next(){
            while (st==null || !st.hasMoreTokens()){
                try {
                    st= new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }
        int nextInt(){
            return     Integer.parseInt(next());
        }
    }

}
