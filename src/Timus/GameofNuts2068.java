package Timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/7/16.
 */
public class GameofNuts2068 {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=fastReader.nextInt();
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=fastReader.nextInt()/2;
        }
        if(sum==0 || sum%2==0) System.out.println("Stannis");
        else System.out.println("Daenerys");
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
