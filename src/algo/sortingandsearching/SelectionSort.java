package algo.sortingandsearching;

import java.util.Arrays;

/**
 * Created by sherxon on 12/18/16.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
//Selection Sort is preferred when memory writes are more expensive than reads, as it makes only O(n) writes
public class SelectionSort {


    public static <T extends Comparable> void sort(T[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) // find min
                if(a[minIndex].compareTo(a[j])>0)
                    minIndex=j;

            if(minIndex!=i){ // swap
                T temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }
        }
    }
    // simple, easy to understand
    public static void sortSimple(int[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) // find min
                if(a[minIndex]>a[j])
                    minIndex=j;

            if(minIndex!=i){ // swap
                int temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 2, 0, 9};
        sortt(a);
        System.out.println(Arrays.toString(a));
    }

    static void sortt(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int current = a[i];
            while (j > 0 && current < a[j - 1])
                a[j] = a[--j];
            a[j] = current;
        }
    }
}
