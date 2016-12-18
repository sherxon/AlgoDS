package algo.sortingandsearching;

/**
 * Created by sherxon on 12/18/16.
 */
public class SelectionSort {


    public static <T extends Comparable> void sort(T[] a){
        for (int i = 0; i < a.length; i++) {
            T min=a[i];
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++)
                if(min.compareTo(a[j])>0) {
                    min=a[j];
                    minIndex=j;
                }
            if(minIndex!=i){
                T temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }
        }
    }
    // simple, easy to understand
    public static void sortSimple(int[] a){
        for (int i = 0; i < a.length; i++) {
            int min=a[i];
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) {
                if(min>a[j]){
                    min=a[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }

        }
    }
}
