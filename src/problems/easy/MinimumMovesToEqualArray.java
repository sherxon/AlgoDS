package problems.easy;

/**
 * Created by sherxon on 1/3/17.
 */
//Incrementing all but one is equivalent to decrementing that one
public class MinimumMovesToEqualArray {
    public int minMoves(int[] a) {
        if(a==null || a.length==0)return 0;
        int min=a[0];
        for(int i=1; i<a.length; i++)
            min=Math.min(a[i], min);
        int sum=0;
        for(int i=0; i<a.length; i++)
            sum+=(a[i]-min);
        return sum;
        // one line solution
        //    return IntStream.of(a).sum() - a.length * IntStream.of(a).min().getAsInt();

    }
}
