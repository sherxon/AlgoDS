package timus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sherxon on 12/3/16.
 */
public class GabyIvanushka1082 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 1; i<=n ; i++) {
            System.out.print(i + " ");
        }
        int a[]= new int[11];
        for (int i = 0; i <10 ; i++) {
            a[i]= (int) (Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        makeHeap(a);
        System.out.println(Arrays.toString(a));
    }

    // this part is not the problem section;


   static void makeHeap(int[] a){
        for (int i = a.length/2; i >=0 ; i--) {
            heapify(a, i);
        }
    }

  static   private void heapify(int[] a, int i) {
        int min=i;
        int left=i*2;
        int right=i*2+1;
        if(left< a.length && a[left] < a[i])min=left;
        if(right<a.length && a[right] < a[min])min=right;

        if(i!=min){
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
            heapify(a, min);
        }




    }


}
