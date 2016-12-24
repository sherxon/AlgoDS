package Timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/4/16.
 */
public class Thebattleneartheswamp1990 {
    public static void main(String[] args) {

        FastReader reader= new FastReader();
        int n=reader.nextInt();
        int k=reader.nextInt();
        int b=0;
        int ad=0;
        int ub=0;
        for (int i = 0; i < n; i++) {
            b=reader.nextInt();
            if(b>k)ub+=b-k;
            else ad+=k-b;
        }
        System.out.println(ub+ " " + ad);


    }

    private static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public static void main(String[] args) {
            FastReader fastReader= new FastReader();
            String s=fastReader.nextLine();
            String s1=fastReader.nextLine();
            String s2=fastReader.next();
            String s3=fastReader.next();
        }

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
