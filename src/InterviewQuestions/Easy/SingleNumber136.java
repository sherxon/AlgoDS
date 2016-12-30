package InterviewQuestions.Easy;

import java.util.Arrays;

/**
 * Created by sherxon on 12/24/16.
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        // Set<Integer> s= new HashSet<>();
        // for(int i : nums){
        //     if(s.contains(i))s.remove(i);
        //     else s.add(i);
        // }
        // return s.iterator().next();
        return Arrays.stream(nums).reduce(0, (a,b)->a^b);
    }
}
