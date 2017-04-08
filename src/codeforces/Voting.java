package codeforces;

import java.util.Scanner;

/**
 * Created by sherxon on 2016-12-25.
 */
public class Voting {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        char[] s=in.nextLine().toCharArray();
        int d=-1;
        int r=-1;
        for (int k = 0; k <s.length; k++) {
            if(s[k]=='D' && d==-1){
              d=k;
            }else if(s[k]=='R' && r==-1){
                r=k;
            }
            if(r>-1 && d>-1)break;
        }
        char c=0;

        for (int i = 0; i < s.length; i++) {
            if(s[i]=='D'){
                if(i<d)continue;
                int j = r+1;
                for (; j<s.length; j++)
                    if(s[i]=='R') break;
                if(j==s.length){
                    c='D';
                    break;
                }
                r=j;
            }else{
                if(i<r)continue;
                int j = d+1;
                for (; j <s.length; j++)
                    if(s[i]=='D') break;
                if(j==s.length) {
                    c='R';
                    break;
                }
                d=j;
            }
        }
        if(c>0) System.out.println(c);
        else{
            System.out.println(r + " " + d);
        }
    }
}
