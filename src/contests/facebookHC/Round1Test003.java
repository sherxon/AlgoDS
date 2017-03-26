package contests.facebookHC;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 1/14/17.
 */
public class Round1Test003 {
    public static void main(String[] args) {
        FastReader reader = new FastReader();

        write("sa");
    }

    private static void write(String s) {
        File output = new File("src/contests/outround1test1.txt");
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
