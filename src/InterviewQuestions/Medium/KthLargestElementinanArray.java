package InterviewQuestions.Medium;

/**
 * Created by sherxon on 12/26/16.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        return f(nums, 0, nums.length-1, nums.length-k);
    }
    int f(int[] a, int lo, int hi, int k ){
        int p=lo+(hi-lo)/2;
        int storeIndex=lo;
        swap(a, p, hi);
        for(int i=lo; i<hi;i++ ){
            if(a[i]<a[hi]){
                swap(a, i, storeIndex);
                storeIndex++;
            }
        }
        swap(a, storeIndex, hi);
        if(storeIndex==k)return a[storeIndex];
        else if(k<storeIndex)return f(a, lo, storeIndex-1, k);
        else return f(a,  storeIndex+1, hi,  k);
    }
    private void swap(int[]a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
