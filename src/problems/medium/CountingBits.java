package problems.medium;

/**
 * @author Sherali Obidov.
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for(int i=0; i<res.length; i++)
            res[i]=res[i/2]+i%2;
        return res;
    }
}
