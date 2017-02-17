package interviewquestions.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 12/30/16.
 */
public class ContainsDuplicate {
    /**
    * In iteration of array We keep track of elements and in each iteration check if this elements is
    * in met already
    * */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(-2 * i)) return true;
        }
        return false;
    }
}
