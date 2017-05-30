package problems.easy;

/**
 * Created by sherxon on 2016-12-27.
 */
public class MergeSortedArray {
    public void merge(int[] a, int m, int[] b, int n) {
        if(a.length==0 || b.length==0)return;
        int i=m-1; int j=n-1; int k=m+n-1;
        while(i>=0 && j>=0 )a[k--]=a[i] > b[j] ? a[i--] : b[j--];
        while(j>=0) a[k--]=b[j--];
    }
}
