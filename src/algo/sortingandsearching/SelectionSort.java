package algo.sortingandsearching;

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
}
