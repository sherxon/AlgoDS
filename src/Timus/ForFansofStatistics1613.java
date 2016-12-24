package Timus;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by sherxon on 12/10/16.
 */
public class ForFansofStatistics1613 {
    public static void main(String[] args) throws IOException {
        FastReader fastReader=new FastReader();
        int n=fastReader.nextInt();
        Map<Integer, TreeSet<Integer>> map= new HashMap<>(n);
        int k;
        for (int i = 1; i <= n; i++) {
            k= fastReader.nextInt();
            if(!map.containsKey(k))
                map.put(k, new TreeSet<>());
            map.get(k).add(i);
        }
        int m=fastReader.nextInt();
        int from, to, j, res;
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            from=fastReader.nextInt();
            to=fastReader.nextInt();
            j=fastReader.nextInt();
            res=0;
            if(map.containsKey(j)) {
               Integer fl=map.get(j).floor(to);
               Integer ce=map.get(j).ceiling(from);
                if(fl!=null && ce!=null && fl.compareTo(ce)>=0)res=1;
            }
            writer.write(String.valueOf(res));
            writer.flush();
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
