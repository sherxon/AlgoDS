package problems.easy;

/**
 * Created by sherxon on 5/4/17.
 */
public class TripleSteps {

    public static void main(String[] args) {
        int numberOfWays=numberOfWays(5);

        System.out.println(numberOfWays);
    }

    public static int numberOfWays(int n) {
        int[] a= new int[n+1];
        a[1]=1;
        a[2]=2;
        a[3]=4;
        if(n < 4) return a[n];
        for (int i = 4; i <= n; i++) {
            a[i]=a[i-1] + a[i-2] + a[i-3];
        }
        return a[n];
    }
}
