package InterviewQuestions.Medium;

/**
 * Created by sherxon on 12/27/16.
 */
public class TwoSumSortedArray {
    public static void main(String[] args) {
        new TwoSumSortedArray().twoSum(new int[]{1,2,3,4,5,6,7,8}, 5);
    }
    public int[] twoSum(int[] a, int t) {
        int i=0;
        int j=a.length-1;
        while (i<j){
            if(a[i]+a[j]==t)break;
            if(a[i]+a[j]<t)i++;
            else j--;
        }


        return new int[]{i+1, j+1};

    }
}
