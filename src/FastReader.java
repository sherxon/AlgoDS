import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/3/16.
 */
public class FastReader {
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
