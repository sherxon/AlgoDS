package InterviewQuestions.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 12/30/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int i: nums){
            if(set.contains(i))return true;
            else set.add(i);
        }

        return false;
    }
}
