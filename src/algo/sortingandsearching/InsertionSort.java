package algo.sortingandsearching;

import java.util.Arrays;

/**
 * Created by sherxon on 12/16/16.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
// used when write operation is expensive
// swapping and shifting are the same complexity , takes constant time
public class InsertionSort {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 10);
        for (int i = 0; i < n; i++) {
            Integer[] a = new Integer[n];
            //int[] a = new int[n];
            for (int j = 0; j < a.length; j++) {
                a[j] = (int) (Math.random() * 10);
            }
            System.out.print(Arrays.toString(a) + " ==>> ");
            sortBySwap(a);
            System.out.print(Arrays.toString(a));
            System.out.println();
        }
    }

    // sorts by shifting
    public static  <T extends Comparable> void sort(T[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0; j--) {
               if(a[j-1].compareTo(a[j])>0){
                   T temp=a[j-1];
                   a[j-1]=a[j];
                   a[j]=temp;
               }
            }
        }
    }
    // sorts by swapping
    public static  <T extends Comparable> void sortBySwap(T[] a){
        for (int i = 1; i < a.length; i++) {
            int j=i;
            T ii=a[i];

            while (j>0 && a[j-1].compareTo(ii)>0) a[j]=a[--j];

            if(j!=i) a[j]=ii;
        }
    }




}
