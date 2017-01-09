package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/7/16.
 */
public class SquareCountry1073 {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader();
        int n=fastReader.nextInt();
        int a[]= new int[(int) Math.sqrt(60000)];
        a[1]=1;
        a[2]=2;
        int k;
        System.out.println(cal(n, 0));
    }

    static int  cal(int n, int c){
        System.out.println(n + " " + c);
        if(Math.sqrt(n)==0 || n<1)return c;
        int min=100;
        for (int i = 1; i <=3; i++) {
            int k=n-i*i;
            if (k>0) {
                int r=cal(k, c+1);
                if(r<min)min=r;
            }

        }
        return min;
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
