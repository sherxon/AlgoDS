package InterviewQuestions;

/**
 * Created by sherxon on 12/27/16.
 */
public class RotateArray {
    public static void main(String[] args) {

        new RotateArray().rotate(new int[]{1,2,3,4,5,6}, 3);
    }
    public void rotate(int[] a, int k) {
        k%=a.length;
        reverse(a, 0, k-1);
        reverse(a, k, a.length);

    }

    private void reverse(int[] a, int lo, int hi) {
        while (lo<hi){
            int temp=a[lo];
            a[lo]=a[hi];
            a[hi]=temp;
            lo++;
            hi--;
        }
    }
}
