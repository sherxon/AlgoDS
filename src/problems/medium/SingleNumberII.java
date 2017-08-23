package problems.medium;

/**
 * @author Sherali Obidov.
 */
public class SingleNumberII {

    /**
    * If you sum the i
     th bit of all numbers and mod 3, it must be either 0 or 1 due to the
     constraint of this problem where each number must appear either three times or once.
     This will be the i
     th bit of that "single number".
     A straightforward implementation is to use an array of size 32 to keep track of the total
     count of i
     th bit.
     from the online discussion
    * */
    public int singleNumber(int[] nums) {
        int[] count= new int[32];
        int res=0;
        for(int i=0; i<count.length; i++){
            for(int j=0; j<nums.length; j++){
                if( ((nums[j] >> i) & 1) == 1){
                    count[i]++;
                }
            }
            res |=( (count[i]%3) << i );
        }
        return res;
    }
}
