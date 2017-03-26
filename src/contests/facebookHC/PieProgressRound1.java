package contests.facebookHC;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 1/14/17.
 */
public class PieProgressRound1 {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> mins = new HashMap<>();

        for (int i = 1; i <= t; i++) {
            map.clear();
            mins.clear();
            long cost = 0;
            int n = reader.nextInt();
            int m = reader.nextInt();
            for (int j = 1; j <= n; j++) {
                mins.put(j, new PriorityQueue<>());
                for (int k = 0; k < m; k++) {
                    mins.get(j).add(reader.nextInt());
                }
                int minCost = mins.get(j).peek();
                long tempCost = cost + minCost + 1;
                int tt = 1;
                int jt = j;
                for (Integer jj : mins.keySet()) {
                    if (mins.get(jj).isEmpty()) continue;
                    int min = mins.get(jj).peek();
                    int times = map.getOrDefault(jj, 0);
                    long val = (long) (Math.pow(times + 1, 2) + min * (times + 1));
                    long oldVal = (long) (Math.pow(times, 2) + min * times);
                    if (cost + val - oldVal <= tempCost) {
                        tempCost = cost + val - oldVal;
                        tt = times + 1;
                        jt = jj;
                        minCost = min;
                    }
                }
                cost = tempCost;
                map.put(jt, tt);
                if (mins.containsKey(jt) && !mins.get(jt).isEmpty())
                    mins.get(jt).poll();

                //System.out.txt.println(tempCost + " " + minCost);
            }
            sb.append("Case #" + i + ": " + cost + "\n");

        }
        write(sb.toString());
    }

    private static void write(String s) {
        File output = new File("src/contests/outround1test3.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new PrintWriter(output));
            writer.write(s);
            writer.flush();
            writer.close();
            System.out.println("done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FastReader {
        BufferedReader bf;
        StringTokenizer st;


        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            String st = "";
            try {
                st = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
