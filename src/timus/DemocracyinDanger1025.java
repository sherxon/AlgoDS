package timus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sherxon on 2016-10-30.
 */
public class DemocracyinDanger1025 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int k=in.nextInt();
        int [] sons=new int[k];
        for (int i = 0; i < k; i++) {
            sons[i]=in.nextInt();
        }
        Arrays.sort(sons);
        int limit=sons.length/2;
        if(sons.length%2!=0)limit+=1;
        int res=0;
        for (int i = 0; i < limit; i++) {
            res+=sons[i]/2;
            if(sons[i]%2!=0)res+=1;
        }
        System.out.println(res);
    }
}
