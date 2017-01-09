package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by sherxon on 12/5/16.
 */
public class CipherMessage {
    public static void main(String[] args) {
        FastReader fastReader= new FastReader();
        char[] s=fastReader.nextLine().toCharArray();
        Stack<Character> stack= new Stack<>();
        for (char c : s) {
            if(!stack.isEmpty()  && stack.peek() ==c)stack.pop();
            else stack.push(c);
        }
        for (Character character : stack) {
            System.out.print(character);
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
