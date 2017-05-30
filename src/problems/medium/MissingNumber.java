package problems.medium;

/**
 * Created by sherxon on 2016-12-26.
 */
public class MissingNumber {
    public int missingNumber(int[] a) {
        int s=0;
        int s1=0;
        for(int i=0; i<a.length; i++){
            s+=i+1;
            s1+=a[i];
        }
        return s-s1;
    }
    public int missingNumber2(int[] a) {
        int x=0;
        int i=0;
        for (int j = 0; j < a.length; j++) {
            x=x^i^a[j];
        }
        return x;
    }
}
