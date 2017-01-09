package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/6/16.
 */
public class SacramentoftheSum1021 {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=fastReader.nextInt();
        int[] a=new int[n];
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i]=fastReader.nextInt();
            set.add(10000 - a[i]);
        }
        String result="NO";
        int m=fastReader.nextInt();
        for (int i = 0; i < m; i++) {
            int k=fastReader.nextInt();
            if(set.contains(k)){
                result="YES";
                break;
            }
        }
        System.out.println(result);



    }


    private static class FastReader {
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
