package contests.facebookHC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 1/6/17.
 */
public class LazyLoading {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=fastReader.nextInt();

        for (int i = 1; i <=n ; i++) {
            int items=fastReader.nextInt();
            int trips=0;
            PriorityQueue<Integer> q= new PriorityQueue<>(items, (a, b)->b.compareTo(a));
            for (int j = 0; j <items ; j++) {
                int weight=fastReader.nextInt();
                if(weight>49)trips++;
                else q.add(weight);
            }
            int fs=q.size();
            while (!q.isEmpty() && fs>0){
                int max=q.peek();
                int needed=(int)Math.ceil(50.0 / max);
                fs-=needed;
                q.poll();
                if(fs>-1)
                    trips++;
            }
            System.out.println("Case #"+i + ": " + trips);

        }
    }
    private static  class FastReader {
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

}
