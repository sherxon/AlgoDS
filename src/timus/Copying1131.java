package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/4/16.
 */
public class Copying1131 {
    public static void main(String[] args) {
        FastReader in= new FastReader();
        int n=in.nextInt();
        int k=in.nextInt();
        int i=1;
        int j=0;
        while (i<=k && i<n){
            i*=2;
            j++;
        }
        System.out.println(Math.round(j+Math.ceil((n-i)/(k*1.0))));


    }
   static private class FastReader {
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
