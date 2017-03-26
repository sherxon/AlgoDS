package contests.facebookHC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 1/6/17.
 */
public class ProgressPie {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        int n=Integer.parseInt(fastReader.nextLine());
        for (int i = 1; i <=n; i++) {
            String[] s=fastReader.nextLine().split(" ");
            int p=Integer.parseInt(s[0]);
            int x=Integer.parseInt(s[1]);
            int y=Integer.parseInt(s[2]);
            calc(p, x, y, i);
        }

    }

    private static void calc(int p, int x, int y, int i) {
        double startAnkle = p*3.6;
        double angle1 = Math.atan2(50, 0);
        double angle2 = Math.atan2(y - 50, x - 50);
        double radius = 50;
        float calculatedAngle = (float) Math.toDegrees(angle1 - angle2);
        if (calculatedAngle < 0) calculatedAngle += 360;

        double ra = Math.sqrt((50-x) * (50-x) + (50-y) * (50-y));

        if(startAnkle > calculatedAngle && ra < radius)
            System.out.println("Case #" + i +": black");
        else
            System.out.println("Case #" + i +": white");

    }


    private static class FastReader {
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
