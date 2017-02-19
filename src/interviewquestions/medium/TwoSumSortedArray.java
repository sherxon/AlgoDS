package interviewquestions.medium;

import java.math.BigInteger;

/**
 * Created by sherxon on 12/27/16.
 */
public class TwoSumSortedArray {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("76");
        BigInteger.valueOf(1);
        System.out.println(bigInteger);

        //    new TwoSumSortedArray().twoSum(new int[]{1,2,3,4,5,6,7,8}, 5);
    }
    public int[] twoSum(int[] a, int t) {
        int i=0;
        int j=a.length-1;
        while (i<j){
            if (a[i] + a[j] > t) j--;
            else if (a[i] + a[j] < t) i++;
            else break;
        }

        return new int[]{i+1, j+1};

    }

}
