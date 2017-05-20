package problems.medium;

/**
 * Created by sherxon on 1/11/17.
 */
public class WordSearch {
    /**
    * This is recursive solution without using global variable
    * */
    boolean exist(char[][] a, String word) {
        int r = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == word.charAt(0)) {
                    char temp = a[i][j];
                    a[i][j] = '.';
                    r = ex(a, word, 1, i, j);
                    a[i][j] = temp;
                }
                if (r == 0) break;
            }
            if (r == 0) break;
        }
        return r == 0;
    }

    private int ex(char[][] a, String word, int n, int i, int j) {
        if (n == word.length()) return 0;
        int r = 1;
        char c = word.charAt(n);

        if (j < a[i].length - 1 && a[i][j + 1] == c && r != 0) {
            char temp = a[i][j + 1];
            a[i][j + 1] = '.';
            r *= ex(a, word, n + 1, i, j + 1);
            a[i][j + 1] = temp;
        }
        if (i < a.length - 1 && a[i + 1][j] == c && r != 0) {
            char temp = a[i + 1][j];
            a[i + 1][j] = '.';
            r *= ex(a, word, n + 1, i + 1, j);
            a[i + 1][j] = temp;
        }
        if (j > 0 && a[i][j - 1] == c && r != 0) {
            char temp = a[i][j - 1];
            a[i][j - 1] = '.';
            r *= ex(a, word, n + 1, i, j - 1);
            a[i][j - 1] = temp;
        }
        if (i > 0 && a[i - 1][j] == c && r != 0) {
            char temp = a[i - 1][j];
            a[i - 1][j] = '.';
            r *= ex(a, word, n + 1, i - 1, j);
            a[i - 1][j] = temp;
        }
        return r;
    }
    /**
    * This is cute solution using global variable
    * */
     class Solution {
        private boolean found=false;

        public boolean exist(char[][] a, String word) {
            char[] s=word.toCharArray();

            for(int i=0; i<a.length && !found; i++){
                for(int j=0; j<a[i].length && !found; j++){
                    if(a[i][j]==s[0])
                        go(a, i, j, s, 0);
                }
            }
            return found;
        }
        void go(char[][]a, int i, int j, char[] s, int index){
            if(i<0 || j<0 || i>=a.length || j>=a[i].length || index >= s.length) return;

            if(s[index]!=a[i][j] || found)return;

            if(index==s.length-1){
                found=true;
                return;
            }
            char temp=a[i][j];
            a[i][j]='.';
            go(a, i+1, j, s, index+1);
            go(a, i, j+1, s, index+1);
            go(a, i-1, j, s, index+1);
            go(a, i, j-1, s, index+1);
            a[i][j]=temp;
        }
    }
}
