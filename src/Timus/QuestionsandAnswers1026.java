package Timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/7/16.
 */
public class QuestionsandAnswers1026 {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int[] a=new int[5001];
        int n=fastReader.nextInt();
        for (int i = 0; i < n; i++)
            a[fastReader.nextInt()]+=1;

        fastReader.next();

        int k=fastReader.nextInt();
        for (int i = 0; i < k; i++) {
            int m=fastReader.nextInt();
            int count=0;
            for (int j = 0; j < a.length; j++) {
                count+=a[j];
                if(count>=m){
                    System.out.println(j);
                    break;
                }
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
