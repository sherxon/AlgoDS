package problems.easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sherxon on 2016-12-30.
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] a= new int[nums.length+1];
        for (int i = 0; i < nums.length; i++)
            a[nums[i]]=1;
        return IntStream.range(1, a.length).filter(i->a[i]==0).boxed().collect(Collectors.toList());
    }
}
