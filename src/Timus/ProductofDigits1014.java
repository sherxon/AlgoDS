package Timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sherxon on 12/3/16.
 */
public class ProductofDigits1014 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        if(n==0) System.out.println(10);
        else{
            List<Integer> set= new ArrayList<>();
            getDivisors(n, set);
            if(set.isEmpty()) System.out.println(-1);
            else set.stream().sorted().forEach(System.out::print);
        }

    }

    private static void getDivisors(int n, List<Integer> set) {
        if(n<10){
            set.add(n);
        }else{
            boolean t=false;
            for (int i = 9; i >1 ; i--) {
                if(n%i==0) {
                    t=true;
                    set.add(i);
                    getDivisors(n/i, set);
                    break;
                }
            }
            if(!t){
                set.clear();
            }
        }

    }
}
