package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/5/16.
 */
public class HistoryExam1196 {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=fastReader.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++)
            a[i]=fastReader.nextInt();
        int m=fastReader.nextInt();
        int count=0;
        int res;
        for (int i = 0; i < m; i++) {
           res=find(a, fastReader.nextInt());
           if(res!=-1) count+=1;//count(a, res);
        }
        System.out.println(count);
    }

    private static int count(int[] a, int res) {
        int i=res;
        int j=res;
        while (i>=0 && a[i--]==a[res]);
        while (j<a.length && a[j++]==a[res]);
        i++;j--;
        return j-i;
    }

    private static int find(int[] a, int n) {
        int i=0;
        int j=a.length-1;
        int mid;
        while (i<=j){
            mid=i+(j-i)/2;
            if(n==a[mid])return mid;
            if(a[mid]>n)j=mid-1;
            else i=mid+1;
        }
        return -1;
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
