package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/6/16.
 */
public class Cryptography1086 {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=fastReader.nextInt();
        boolean a[] =new boolean[163848];
        a[1]=false;
        a[2]=false;

        for (int i = 2; i*i < a.length; i++) {
            int j=i*i;
            if(!a[i])
            for (; j>0 && j <a.length ; j+=i) {
                a[j]=true;
            }
        }
        int res[] =new int[15001];
        int c=1;
        for (int i = 2; i < a.length && c<res.length; i++) {
            if(!a[i])res[c++]=i;
        }

        for (int i = 0; i < n; i++) {
            int k=fastReader.nextInt();
            System.out.println(res[k]);
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
