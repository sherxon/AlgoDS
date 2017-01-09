package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/13/16.
 */
public class PhoneNumbers1002 {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=0;
        while (n!=-1){
             String num=fastReader.next();
             n=fastReader.nextInt();
            for (int i = 0; i < n; i++) {

            }

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
