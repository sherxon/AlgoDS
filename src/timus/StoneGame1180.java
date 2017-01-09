package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/7/16.
 */
public class StoneGame1180 {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader();
        char[] s =fastReader.next().toCharArray();
        long sum=0;
        for (int i = 0; i < s.length; i++) {
            sum+=s[i]-'0';
        }
        if(sum%3==0) System.out.println(2);
        else {
            System.out.println(1);
            System.out.println(sum%3);
        }

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
