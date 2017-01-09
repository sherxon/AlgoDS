package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 1/6/17.
 */
 class FastReader {
    BufferedReader bf;
    StringTokenizer st;


    public FastReader() {
        bf=new BufferedReader(new InputStreamReader(System.in));
    }
  public   String nextLine(){
        String st="";
        try {
            st=bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  st;
    }
  public   String next(){
        while (st==null || !st.hasMoreTokens()){
            try {
                st= new StringTokenizer(bf.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return st.nextToken();
    }
   public int nextInt(){
        return     Integer.parseInt(next());
    }
}
