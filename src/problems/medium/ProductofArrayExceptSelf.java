package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/2/17.
 */
public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        List<Double> a= new ArrayList<>();
        a.add(10.0);
        a.add(1.0);
        a.add(10.0);
        a.add(20.0);
        a.add(100.0);
        for (int i = 1; i <=10; i++) {
            int rand=(int) (Math.random()*a.size());
            System.out.println(a.get(rand));
        }
    }
    public int[] productExceptSelf(int[] a) {
        if(a==null) return new int[0];

        if(a.length==0)return a;
        int[] b= new int[a.length];
        int[] c= new int[a.length];
        b[0]=1;
        c[c.length-1]=1;

        for(int i=1; i<a.length; i++)
            b[i]=a[i-1] * b[i-1];

        for(int i=a.length-2; i>=0; i--)
            c[i]=a[i+1] * c[i+1];

        for(int i=0; i<a.length; i++)
            a[i]=b[i]*c[i];
        return a;
    }
}
