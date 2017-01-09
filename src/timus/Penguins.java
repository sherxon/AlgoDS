package timus;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/4/16.
 */
public class Penguins {
    public static void main(String[] args) throws IOException {
        FastReader reader=new FastReader();
        int n=Integer.parseInt(reader.nextLine());
        Map<String, Integer> ma= new HashMap<>();

        for (int i = 0; i <n ; i++) {
            String s=reader.nextLine();
            if(!ma.containsKey(s))
                ma.put(s, 1);
            else
                ma.put(s, ma.get(s)+1);
        }
        int max=0;
        String s=null;
        for (String s1 : ma.keySet()) {
            if(ma.get(s1) > max){
                max=ma.get(s1);
                s=s1;
            }
        }
        BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(s);
        writer.flush();
        writer.close();
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
