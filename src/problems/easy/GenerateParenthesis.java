package problems.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sherxon on 5/5/17.
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

  static  public List<String> generateParenthesis(int n) {
        char[] a=new char[n*2];
        for(int i=0; i<a.length-1; i+=2){
            a[i]='(';
            a[i+1]=')';
        }
        Set<String> set=new HashSet<>();
        generate(a, set, 0);
        return new ArrayList<>(set);

    }
   static void generate(char[] a, Set<String> set, int n){
        if(n == a.length-1){
            set.add(new String(a));
        }else if(a[n] == ')'){
            for(int i=n; i<a.length; i++){
                if(a[i] != a[n] || i==n){
                    char temp=a[i];
                    a[i]=a[n];
                    a[n]=temp;
                    generate(a, set, n+1);
                    temp=a[i];
                    a[i]=a[n];
                    a[n]=temp;
                }

            }
        }else {
            generate(a, set, n+1);
        }
    }
}
