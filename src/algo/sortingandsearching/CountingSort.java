package algo.sortingandsearching;

import java.util.Arrays;

/**
 * Created by sherxon on 12/20/16.
 */

public class CountingSort {

    public static void sort(int[] a){
        int max=0;
        for (int i = 0; i < a.length; i++)
            max=Math.max(a[i], max);
        max+=1;

        int[] count=new int[max];
        for (int i = 0; i < a.length; i++)
            count[a[i]]++;

        for (int i = 1; i < count.length; i++)
            count[i]+=count[i-1];

        int[] sorted= new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int index=count[a[i]];
            sorted[index-1]=a[i];
            count[a[i]]--;
        }
        System.out.print(Arrays.toString(sorted));
        System.out.println();
    }
}
