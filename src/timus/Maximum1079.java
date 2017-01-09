package timus;

import java.util.Scanner;

/**
 * Created by sherxon on 12/3/16.
 */
public class Maximum1079 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int[] a= new int[10];
        int j=0;
        while (in.hasNext()){
            int i=in.nextInt();
            if(i==0)break;
            a[j]=i;
            j++;
        }
        int max=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]>max)max=a[i];
        }
        int [] res=new int[max+1];
        res[0]=0;
        res[1]=1;
        for (int i = 2; i <=max; i++) {
                res[i]=i%2==0 ? res[i/2] :res[(i/2)] + res[i/2+1];
        }
        for (int i = 0; i <a.length ; i++) {
            if(a[i]!=0){
                max=-1;
                for (int k = 0; k <=a[i]; k++) {
                    if(res[k]>max)max=res[k];
                }
                System.out.println(max);
            }
        }

    }
}
